/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qilinapp.htgl.model.TabDoc;
import com.qilinapp.htgl.model.TabYh;
import com.qilinapp.htgl.service.ITabDocService;
import com.qilinapp.htgl.util.StringUtils;
import com.qilinapp.htgl.util.TimeUtils;

import net.sf.json.JSONObject;

/**
 * @author：QYW
 * @since：2019年4月4日上午11:02:33
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Controller
@RequestMapping(value = "/doc")
public class DocController {
	@Resource
	private ITabDocService tabDocService;
 
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request) {
		return "doc/list";
	}

	@RequestMapping(value = "/upload")
	public String upload(Model model, HttpServletRequest request) {
		return "doc/upload";
	}

	@RequestMapping(value = "/query")
	public String query(Model model, HttpServletRequest request) {
		return "doc/query";
	}

	@RequestMapping(value = "/listData")
	@ResponseBody
	public Map<String, Object> listData(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		TabYh yh = (TabYh) request.getSession().getAttribute("yh");
		int page = Integer.parseInt(request.getParameter("page"));// 当前页
		int rows = Integer.parseInt(request.getParameter("rows"));// 每页记录数
		String order = request.getParameter("order");
		String sort = request.getParameter("sort");
		String scsje = request.getParameter("scsje");
		String scsjs = request.getParameter("scsjs");
		scsje = TimeUtils.wdatePickerFormat(scsje);
		scsjs = TimeUtils.wdatePickerFormat(scsjs);
		map.put("startRow", (page - 1) * rows);
		map.put("endRow", page * rows);
		map.put("rows", rows);
		map.put("order", order);
		map.put("sort", sort);
		map.put("qyidMh", yh.getQyid());
		map.put("scsje", scsje);
		map.put("scsjs", scsjs);
		List<TabDoc> list = tabDocService.findDocByPage(map);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("total", tabDocService.getCount(map));
		m.put("rows", list);
		return m;
	}

	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String uploadfile(@RequestParam(value = "file", required = false) MultipartFile multipartFile,
			HttpServletRequest request, HttpServletResponse res) {
		System.err.println("upload");
		JSONObject json = new JSONObject();
		try {
			TabYh yh = (TabYh) request.getSession().getAttribute("yh");
			if (yh != null) {
				String fileName = multipartFile.getOriginalFilename();
				String time = TimeUtils.getTime();
				File targetFile = new File("C:\\document\\" + yh.getYhid() + "-" + time, fileName);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				multipartFile.transferTo(targetFile);

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("uuid", StringUtils.getUUID());
				map.put("createtime", time);
				map.put("qyid", yh.getQyid());
				map.put("yhid", yh.getYhid());
				map.put("sclx", "upload");
				map.put("wjm", fileName);
				map.put("filepath", "C:\\document\\" + yh.getYhid() + "-" + time);

				//map.put("url", "http://47.102.221.210/document/" + yh.getYhid() + "-" + time + "/" + fileName);

				boolean b = tabDocService.insert(map);

				if (b) {
					json.put("retCode", 1);
					json.put("MSG", "上传成功！");
				} else {
					json.put("retCode", 0);
					json.put("MSG", "上传失败！");
				}
			}
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			json.put("retCode", -1);
			json.put("MSG", "发生异常：" + e.getMessage());
			e.printStackTrace();
		}
		return json.toString();

	}

	@SuppressWarnings("resource")
	@RequestMapping("/down")
	public void down(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String uuid = (String) request.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uuid", uuid);
		TabDoc tabDoc = tabDocService.findDoc(map);
        String path = tabDoc.getFilepath();
        String filename = tabDoc.getWjm();
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(path + "\\" + filename)));
        filename = URLEncoder.encode(filename,"UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
	}
}
