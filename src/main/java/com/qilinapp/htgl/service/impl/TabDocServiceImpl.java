/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qilinapp.htgl.dao.ITabDocDao;
import com.qilinapp.htgl.model.TabDoc;
import com.qilinapp.htgl.service.ITabDocService;

/**    
 * @author：QYW   
 * @since：2019年4月8日上午11:24:22
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
@Service
public class TabDocServiceImpl implements ITabDocService {
	@Resource
	private ITabDocDao tabDocDao;

	@Override
	public List<TabDoc> findDocByPage(Map<String, Object> map) {
		try {
			return tabDocDao.findDocByPage(map);
		} catch (Exception e) {
			System.err.println("查询doc异常!" + e);
		}
		return null;
	}

	@Override
	public int getCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			return tabDocDao.getCount(map);
		} catch (Exception e) {
			System.err.println("查询doc总数异常!" + e);
		}
		return 0;
	}

	@Override
	public boolean insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			tabDocDao.insert(map);
			return true;
		} catch (Exception e) {
			System.err.println("新增doc异常!" + e);
		}
		return false;
	}

	@Override
	public TabDoc findDoc(Map<String, Object> map) {
		try {
			return tabDocDao.findDoc(map);
		} catch (Exception e) {
			System.err.println("查询doc异常!" + e);
		}
		return null;
	}

}
