/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.service;

import java.util.List;
import java.util.Map;

import com.qilinapp.htgl.model.TabOCR;

/**    
 * @author：QYW   
 * @since：2019年3月21日上午11:04:00
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public interface ITabOCRService {

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
	 * @return: Object      
	 * @throws   
	 */
	int getCount(Map<String, Object> map);

	/**   
	 * @Title: insert   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	boolean insert(Map<String, Object> map);

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
