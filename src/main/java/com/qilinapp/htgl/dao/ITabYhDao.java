/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.dao;

import java.util.Map;

import com.qilinapp.htgl.model.TabYh;

/**    
 * @author：QYW   
 * @since：2019年3月19日上午10:45:53
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITabYhDao {

	/**   
	 * @Title: findYh   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: TabYh      
	 * @throws   
	 */
	TabYh findYh(Map<String, Object> map);

}
