/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.dao;

import java.util.List;
import java.util.Map;

import com.qilinapp.htgl.model.TabGn;


/**    
 * @author：QYW   
 * @since：2019年3月19日上午10:46:25
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITabGnDao {


	/**
	 * @return    
	 * @Title: findGn   
	 * @Description: 
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	List<TabGn> findGn();

	

	/**   
	 * @Title: loadMenuTree   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<TabGn>      
	 * @throws   
	 */
	List<TabGn> loadMenuTree(Map<String, Object> map);

}
