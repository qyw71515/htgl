/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qilinapp.htgl.model.TabImg;
import com.qilinapp.htgl.model.TabYh;
import com.qilinapp.htgl.service.ITabImgService;
import com.qilinapp.htgl.util.StringUtils;
import com.qilinapp.htgl.util.TimeUtils;

import net.coobird.thumbnailator.Thumbnails;
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
@RequestMapping(value = "/img")
public class ImgController {
	@Resource
	private ITabImgService tabImgService;

	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request) {
		return "img/list";
	}

	@RequestMapping(value = "/upload")
	public String upload(Model model, HttpServletRequest request) {
		return "img/upload";
	}

	@RequestMapping(value = "/query")
	public String query(Model model, HttpServletRequest request) {
		return "img/query";
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
		List<TabImg> list = tabImgService.findImgByPage(map);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("total", tabImgService.getCount(map));
		m.put("rows", list);
		return m;
	}

	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String uploadImg(@RequestParam(value = "file", required = false) MultipartFile multipartFile,
			HttpServletRequest request, HttpServletResponse res) {
		JSONObject json = new JSONObject();
		try {
			TabYh yh = (TabYh) request.getSession().getAttribute("yh");
			if (yh != null) {
				String fileName = multipartFile.getOriginalFilename();
				String time = TimeUtils.getTime();
				File targetFile = new File("C:\\images\\" + yh.getYhid() + "-" + time, fileName);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				multipartFile.transferTo(targetFile);

				// 生成缩略图
				Thumbnails.of(new File("C:\\images\\" + yh.getYhid() + "-" + time, fileName)).size(320, 320)
						.toFile(new File("C:\\images\\" + yh.getYhid() + "-" + time, "small-" + fileName));

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("uuid", StringUtils.getUUID());
				map.put("createtime", time);
				map.put("qyid", yh.getQyid());
				map.put("yhid", yh.getYhid());
				map.put("sclx", "upload");
				map.put("wjm", fileName);
				map.put("filepath", "C:\\images\\" + yh.getYhid() + "-" + time);
				map.put("by1", "http://47.102.221.210/images/"+ yh.getYhid() + "-" + time + "/" + fileName);
				map.put("by2", "http://47.102.221.210/images/"+ yh.getYhid() + "-" + time + "/small-" + fileName);
				boolean b = tabImgService.insert(map);
				
				if (b) {
					json.put("retCode", 1);
					json.put("MSG", "上传成功！");
				} else {
					json.put("retCode", 0);
					json.put("MSG", "上传失败!\"");
				}
				
				
	
				
				
				
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			json.put("retCode", -1);
			json.put("MSG", "发生异常："+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			json.put("retCode", -1);
			json.put("MSG", "发生异常："+e.getMessage());
			e.printStackTrace();
		}

		return json.toString();

	}

	@SuppressWarnings("resource")
	@RequestMapping(value = "/showPic")
	public ResponseEntity<byte[]> showPic(HttpServletRequest request, HttpServletResponse response) {

		
		try {
			String uuid = (String) request.getParameter("id");
			String type = (String) request.getParameter("type");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("uuid", uuid);
			TabImg img = tabImgService.findImg(map);
			
			FileImageInputStream input = null;
			File file;
			if("b".equals(type)) {
				file = new File(img.getFilepath() + "\\" + img.getWjm());
			}else {
				file = new File(img.getFilepath() + "\\small-" + img.getWjm());
			}
			input = new FileImageInputStream(file);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			byte[] data = output.toByteArray();
			
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

	}
}
