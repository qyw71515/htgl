/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qilinapp.htgl.dao.ITabOCRDao;
import com.qilinapp.htgl.model.TabOCR;
import com.qilinapp.htgl.service.ITabOCRService;

/**
 * @author：QYW
 * @since：2019年3月21日上午11:06:07
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Service
public class TabOCRServiceImpl implements ITabOCRService {
	@Resource
	private ITabOCRDao tabOCRDao;

	public List<TabOCR> findOCRByPage(Map<String, Object> map) {
		try {
			return tabOCRDao.findOCRByPage(map);
		} catch (Exception e) {
			System.err.println("查询ocr异常!" + e);
		}
		return null;
	}

	public int getCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			return tabOCRDao.getCount(map);
		} catch (Exception e) {
			System.err.println("查询ocr总数异常!" + e);
		}
		return 0;
	}

	@Override
	public boolean insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			tabOCRDao.insert(map);
			return true;
		} catch (Exception e) {
			System.err.println("新增ocr异常!" + e);
		}
		return false;
	}

	@Override
	public TabOCR findOCR(Map<String, Object> map) {
		try {
			return tabOCRDao.findOCR(map);
		} catch (Exception e) {
			System.err.println("查询ocr异常!" + e);
		}
		return null;
	}

}
