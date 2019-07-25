/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.dao;

import java.util.List;
import java.util.Map;

import com.qilinapp.htgl.model.TabLog;

/**    
 * @author：QYW   
 * @since：2019年3月19日上午10:46:35
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITabLogDao {

	/**   
	 * @Title: insertLog   
	 * @Description: 
	 * @param: @param logmap
	 * @param: @return      
	 * @return: Object      
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
	 * @return: int      
	 * @throws   
	 */
	int getCount(Map<String, Object> map);

}
