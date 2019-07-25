/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qilinapp.htgl.dao.ITabLogDao;
import com.qilinapp.htgl.model.TabLog;
import com.qilinapp.htgl.service.ITabLogService;

/**
 * @author：QYW
 * @since：2019年3月19日上午10:32:18
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Service
public class TabLogServiceImpl implements ITabLogService {
	@Resource
	private ITabLogDao tabLogDao;

	public void insertLog(Map<String, Object> logmap) {
		// TODO Auto-generated method stub
		try {
			tabLogDao.insertLog(logmap);
		} catch (Exception e) {
			System.err.println("新增日志异常!" + e);
		}
	}

	public List<TabLog> findLogByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			return tabLogDao.findLogByPage(map);
		} catch (Exception e) {
			System.err.println("查询日志异常!" + e);
		}
		return null;
	}

	public int getCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			return tabLogDao.getCount(map);
		} catch (Exception e) {
			System.err.println("查询日志总数异常!" + e);
		}
		return 0;
	}

}
