/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.dao;

import java.util.List;
import java.util.Map;

import com.qilinapp.htgl.model.TabOCR;

/**    
 * @author：QYW   
 * @since：2019年3月22日上午10:02:05
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITabOCRDao {

	/**   
	 * @Title: insert   
	 * @Description: 
	 * @param: @param map      
	 * @return: void      
	 * @throws   
	 */
	void insert(Map<String, Object> map);

	/**   
	 * @Title: findOCRByPage   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<TabLog>      
	 * @throws   
	 */
	List<TabOCR> findOCRByPage(Map<String, Object> map);

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
	 * @Title: findOCR   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: TabOCR      
	 * @throws   
	 */
	TabOCR findOCR(Map<String, Object> map);

}
