/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
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
 * @author��QYW
 * @since��2019��3��21������11:06:07
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com)
 */
@Service
public class TabOCRServiceImpl implements ITabOCRService {
	@Resource
	private ITabOCRDao tabOCRDao;

	public List<TabOCR> findOCRByPage(Map<String, Object> map) {
		try {
			return tabOCRDao.findOCRByPage(map);
		} catch (Exception e) {
			System.err.println("��ѯocr�쳣!" + e);
		}
		return null;
	}

	public int getCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			return tabOCRDao.getCount(map);
		} catch (Exception e) {
			System.err.println("��ѯocr�����쳣!" + e);
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
			System.err.println("����ocr�쳣!" + e);
		}
		return false;
	}

	@Override
	public TabOCR findOCR(Map<String, Object> map) {
		try {
			return tabOCRDao.findOCR(map);
		} catch (Exception e) {
			System.err.println("��ѯocr�쳣!" + e);
		}
		return null;
	}

}
