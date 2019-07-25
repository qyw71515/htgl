/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.dao;

import java.util.List;
import java.util.Map;

import com.qilinapp.htgl.model.TabDoc;

/**    
 * @author：QYW   
 * @since：2019年4月8日上午11:25:39
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITabDocDao {

	/**   
	 * @Title: findDocByPage   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<TabDoc>      
	 * @throws   
	 */
	List<TabDoc> findDocByPage(Map<String, Object> map);

	/**   
	 * @Title: getCount   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	int getCount(Map<String, Object> map);

	/**   
	 * @Title: insert   
	 * @Description: 
	 * @param: @param map      
	 * @return: void      
	 * @throws   
	 */
	void insert(Map<String, Object> map);

	/**   
	 * @Title: findDoc   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: TabDoc      
	 * @throws   
	 */
	TabDoc findDoc(Map<String, Object> map);

}
