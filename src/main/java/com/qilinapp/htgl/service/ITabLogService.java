/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.service;

import java.util.List;
import java.util.Map;

import com.qilinapp.htgl.model.TabLog;

/**    
 * @author：QYW   
 * @since：2019年3月19日上午9:46:41
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITabLogService {

	/**   
	 * @Title: insertLog   
	 * @Description: 
	 * @param: @param logmap      
	 * @return: void      
	 * @throws   
	 */
	void insertLog(Map<String, Object> logmap);

	/**   
	 * @Title: findLogByPage   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<TabLog>      
	 * @throws   
	 */
	List<TabLog> findLogByPage(Map<String, Object> map);

	/**   
	 * @Title: getCount   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: Object      
	 * @throws   
	 */
	int getCount(Map<String, Object> map);

}
