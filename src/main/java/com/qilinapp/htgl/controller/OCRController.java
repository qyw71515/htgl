/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.baidu.aip.ocr.AipOcr;
import com.qilinapp.htgl.model.TabOCR;
import com.qilinapp.htgl.model.TabYh;
import com.qilinapp.htgl.service.ITabOCRService;
import com.qilinapp.htgl.util.StringUtils;
import com.qilinapp.htgl.util.TimeUtils;

import net.sf.json.JSONObject;

/**
 * @author：QYW
 * @since：2019年3月21日上午11:02:15
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Controller
@RequestMapping(value = "/ocr")
public class OCRController {
	@Resource
	private ITabOCRService tabOCRService;

	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request) {
		return "ocr/list";
	}

	@RequestMapping(value = "/upload")
	public String upload(Model model, HttpServletRequest request) {
		System.err.println("ocr/upload");
		return "ocr/upload";
	}

	@RequestMapping(value = "/query")
	public String query(Model model, HttpServletRequest request) {
		return "ocr/query";
	}

	@RequestMapping(value = "/viewPic")
	public String viewPic(Model model, HttpServletRequest request) {
		String uuid = request.getParameter("uuid");
		model.addAttribute("uuid", uuid);
		return "ocr/viewpic";
	}

	@RequestMapping(value = "/viewMsg")
	public String viewMsg(Model model, HttpServletRequest request) {
		String uuid = request.getParameter("uuid");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uuid", uuid);
		System.err.println(map);
		TabOCR ocr = tabOCRService.findOCR(map);

		model.addAttribute("wjm", ocr.getBy1());
		model.addAttribute("createtime", ocr.getCreatetime());
		model.addAttribute("lx", ocr.getLx());
		model.addAttribute("msg", ocr.getRetmsg());
		System.err.println(ocr.getRetmsg());
		return "ocr/view";
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
		List<TabOCR> list = tabOCRService.findOCRByPage(map);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("total", tabOCRService.getCount(map));
		m.put("rows", list);
		return m;
	}

	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String uploadImg(@RequestParam(value = "file", required = false) MultipartFile multipartFile,
			HttpServletRequest request, HttpServletResponse res) throws Exception {
		TabYh yh = (TabYh) request.getSession().getAttribute("yh");
		JSONObject json = new JSONObject();
		try {
			/*
			 * 保存导入文件
			 */
			CommonsMultipartFile commonsmultipartfile = (CommonsMultipartFile) multipartFile;
			DiskFileItem diskFileItem = (DiskFileItem) commonsmultipartfile.getFileItem();
			File File = diskFileItem.getStoreLocation();
			System.err.println("file-->" + File.length());
			Long size = File.length();
			if (size > 0 && size < 5 * 1024 * 1024) {
				String originalFilename = multipartFile.getOriginalFilename();

				String hz = "";
				if (originalFilename != null && originalFilename.contains(".")) {
					int i = originalFilename.lastIndexOf(".");
					hz = originalFilename.substring(i, originalFilename.length());
					hz = hz.toLowerCase();
					if (hz.equals(".jpg") || hz.equals(".png") || hz.equals(".bmp") || hz.equals(".jpeg")
							|| hz.equals(".gif")) {

						String APP_ID = "15761218";
						String API_KEY = "dUjzNC5NBv45Vhw7PfVx0fbK";
						String SECRET_KEY = "gz9zY4Dxme2InMckkMmloBSq90qaGCdD";

						// 参数为二进制数组

						FileImageInputStream input = null;

						input = new FileImageInputStream(File);
						ByteArrayOutputStream output = new ByteArrayOutputStream();
						byte[] buf = new byte[1024];
						int numBytesRead = 0;
						while ((numBytesRead = input.read(buf)) != -1) {
							output.write(buf, 0, numBytesRead);
						}
						byte[] data = output.toByteArray();
						output.close();
						input.close();

						String lx = request.getParameter("lx");
						System.err.println(lx);
						AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
						String retcontent = sample(client, data, lx);
						System.err.println(retcontent);
						boolean flag = false;
						Map<String, Object> map = new HashMap<String, Object>();
						String uuid = StringUtils.getUUID();
						map.put("uuid", uuid);
						map.put("createtime", TimeUtils.getTime());
						map.put("qyid", yh.getQyid());
						map.put("yhid", yh.getYhid());
						map.put("lx", lxFormat(lx));
						map.put("tp", data);
						map.put("retmsg", retcontent);
						map.put("by1", originalFilename);

						flag = tabOCRService.insert(map);
						if (flag) {
							json.put("retCode", 1);
							json.put("uuid", uuid);
							json.put("MSG", "上传成功！");
						} else {
							json.put("retCode", 0);
							json.put("MSG", "上传失败!\"");
						}
					} else {
						json.put("retCode", 0);
						json.put("MSG", "请使用文件格式为jpg 或 gif 或 jpeg 或 png 或 bmp 的文件!");
					}
				} else {
					json.put("retCode", 0);
					json.put("MSG", "文件名错误!");
				}
			} else {
				json.put("retCode", 0);
				json.put("MSG", "文件size不符合规范!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.put("retCode", -1);
			json.put("MSG", "发生异常:" + e.getLocalizedMessage());
		}

		return json.toString();

	}

	@RequestMapping(value = "/getImg")
	public ResponseEntity<byte[]> getImg(HttpServletRequest request, HttpServletResponse response) {

		String uuid = (String) request.getParameter("uuid");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uuid", uuid);
		System.err.println(map);
		TabOCR ocr = tabOCRService.findOCR(map);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(ocr.getTp());

	}

	public static String sample(AipOcr client, byte[] file, String lx) {
		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("language_type", "CHN_ENG");
		options.put("detect_direction", "true");
		options.put("detect_language", "true");
		options.put("probability", "true");

		org.json.JSONObject res = null;
		// 参数为本地路径
		if ("ty".equals(lx)) {
			res = client.basicGeneral(file, options);
		} else if ("tygjd".equals(lx)) {
			res = client.basicAccurateGeneral(file, options);
		} else if ("fp".equals(lx)) {
			res = client.vatInvoice(file, options);
		} else {
			res = client.basicGeneral(file, options);
		}

		return res.toString();
	}

	private String lxFormat(String lx) {
		if ("ty".equals(lx)) {
			return "通用文字识别";
		} else if ("tygjd".equals(lx)) {
			return "通用文字识别（高精度版）";
		} else if ("fp".equals(lx)) {
			return "增值税发票识别";
		} else {
			return "通用文字识别";
		}
	}
}
