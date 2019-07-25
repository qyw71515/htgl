/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.service;

import java.util.Map;

import com.qilinapp.htgl.model.TabYh;

/**    
 * @author：QYW   
 * @since：2019年3月19日上午8:40:33
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITabYhService {

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
