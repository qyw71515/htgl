/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.service;

import java.util.List;
import java.util.Map;

import com.qilinapp.htgl.pojo.Menu;


/**    
 * @author：QYW   
 * @since：2019年3月19日上午10:26:32
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITabGnService {

	/**   
	 * @Title: loadMenuTree   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<Menu>      
	 * @throws   
	 */
	List<Menu> loadMenuTree(Map<String, Object> map);


}
