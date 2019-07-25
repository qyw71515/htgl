/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.dao;

import java.util.Map;

import com.qilinapp.htgl.model.TabQy;

/**    
 * @author：QYW   
 * @since：2019年3月19日上午10:45:14
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITabQyDao {

	/**   
	 * @Title: findQy   
	 * @Description: 
	 * @param: @param qymap
	 * @param: @return      
	 * @return: TabQy      
	 * @throws   
	 */
	TabQy findQy(Map<String, Object> qymap);

}
