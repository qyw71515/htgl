/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qilinapp.htgl.dao.ITabGnDao;
import com.qilinapp.htgl.model.TabGn;
import com.qilinapp.htgl.pojo.Menu;
import com.qilinapp.htgl.service.ITabGnService;



/**
 * @author：QYW
 * @since：2019年3月19日上午10:32:04
 * @description:
 * @version: 1.0
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com)
 */
@Service
public class TabGnServiceImpl implements ITabGnService {
	@Resource
	private ITabGnDao tabGnDao;

//	public String loadMenuTree(Map<String, Object> map) {
//		// TODO Auto-generated method stub
//		try {
//			map.put("zt", "1");
//			List<TabGn> list = tabGnDao.loadMenuTree(map);
//			JSONArray menuarr = new JSONArray();
//			for(TabGn gn1 : list) {
//				if("0".equals(gn1.getSjgnbh())) {
//					JSONObject m1 = new JSONObject();
//					m1.put("id", gn1.getGnbh());
//					m1.put("parentId", gn1.getSjgnbh());
//					m1.put("url", gn1.getUrl());
//					m1.put("iconCls", gn1.getIcon());
//					m1.put("text", gn1.getGnms());
//					m1.put("state", "close");
//					
//					JSONArray menuarr2 = new JSONArray();
//					for(TabGn gn2 : list) {
//						if(gn2.getSjgnbh().equals(gn1.getGnbh())) {
//							JSONObject m2 = new JSONObject();
//							m2.put("id", gn2.getGnbh());
//							m2.put("parentId", gn2.getSjgnbh());
//							m2.put("url", gn2.getUrl());
//							m2.put("iconCls", gn2.getIcon());
//							m2.put("text", gn2.getGnms());
//							m2.put("state", "close");
//							
//							JSONArray menuarr3 = new JSONArray();
//							for(TabGn gn3 : list) {
//								if(gn3.getSjgnbh().equals(gn2.getGnbh())) {
//									JSONObject m3 = new JSONObject();
//									m3.put("id", gn3.getGnbh());
//									m3.put("parentId", gn3.getSjgnbh());
//									m3.put("url", gn3.getUrl());
//									m3.put("iconCls", gn3.getIcon());
//									m3.put("text", gn3.getGnms());
//									m3.put("state", "close");
//									menuarr3.add(m3);
//								}
//							}
//							m2.put("children", menuarr3);
//							menuarr2.add(m2);
//						}
//					}
//					m1.put("children", menuarr2);
//					menuarr.add(m1);
//				}
//			}
//			System.err.println(menuarr);
//			
//			return menuarr.toString();
//		} catch (Exception e) {
//			System.err.println("组装功能树异常!" + e);
//		}
//		return null;
//	}
	public List<Menu> loadMenuTree(Map<String, Object> map) {
		// TODO Auto-generated method stub
		try {
			map.put("zt", "1");
			List<TabGn> list = tabGnDao.loadMenuTree(map);
			List<Menu> menulist = new ArrayList<Menu>();
			for(TabGn gn1 : list) {
				if("0".equals(gn1.getSjgnbh())) {
					List<Menu> menulist1 = new ArrayList<Menu>();
					for(TabGn gn2 : list) {
						if(gn1.getGnbh().equals(gn2.getSjgnbh())) {
							List<Menu> menulist2 = new ArrayList<Menu>();
							for(TabGn gn3 : list) {
								if(gn2.getGnbh().equals(gn3.getSjgnbh())) {
									Menu menu3 = new Menu();
									menu3.setMenuid(gn3.getGnbh());
									menu3.setMenuname(gn3.getGnms());
									menu3.setIcon(gn3.getIcon());
									menu3.setUrl(gn3.getUrl());
									menulist2.add(menu3);
								}
							}
							Menu menu2 = new Menu();
							menu2.setMenuid(gn2.getGnbh());
							menu2.setMenuname(gn2.getGnms());
							menu2.setIcon(gn2.getIcon());
							menu2.setUrl(gn2.getUrl());
							menu2.setChild(menulist2);
							menulist1.add(menu2);
						}
					}
					Menu menu1 = new Menu();
					menu1.setMenuid(gn1.getGnbh());
					menu1.setMenuname(gn1.getGnms());
					menu1.setIcon(gn1.getIcon());
					menu1.setUrl(gn1.getUrl());
					menu1.setChild(menulist1);
					menulist.add(menu1);
				}
			}
			System.err.println(menulist);
			
			return menulist;
		} catch (Exception e) {
			System.err.println("组装功能树异常!" + e);
		}
		return null;
	}
}
