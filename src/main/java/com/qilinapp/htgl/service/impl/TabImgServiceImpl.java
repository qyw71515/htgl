/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qilinapp.htgl.dao.ITabImgDao;
import com.qilinapp.htgl.model.TabImg;
import com.qilinapp.htgl.service.ITabImgService;

/**
 * @author：QYW
 * @since：2019年4月4日上午11:26:40
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Service
public class TabImgServiceImpl implements ITabImgService {
	@Resource
	private ITabImgDao tabImgDao;

	@Override
	public List<TabImg> findImgByPage(Map<String, Object> map) {
		try {
			return tabImgDao.findImgByPage(map);
		} catch (Exception e) {
			System.err.println("查询img异常!" + e);
		}
		return null;
	}

	@Override
	public int getCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			return tabImgDao.getCount(map);
		} catch (Exception e) {
			System.err.println("查询img总数异常!" + e);
		}
		return 0;
	}

	@Override
	public boolean insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			tabImgDao.insert(map);
			return true;
		} catch (Exception e) {
			System.err.println("新增img异常!" + e);
		}
		return false;
	}

	@Override
	public TabImg findImg(Map<String, Object> map) {
		try {
			return tabImgDao.findImg(map);
		} catch (Exception e) {
			System.err.println("查询img异常!" + e);
		}
		return null;
	}

}
