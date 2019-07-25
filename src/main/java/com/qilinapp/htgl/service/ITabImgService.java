/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.qilinapp.htgl.service;

import java.util.List;
import java.util.Map;

import com.qilinapp.htgl.model.TabImg;

/**    
 * @author��QYW   
 * @since��2019��4��4������11:23:05
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
public interface ITabImgService {

	/**   
	 * @Title: findImgByPage   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<TabImg>      
	 * @throws   
	 */
	List<TabImg> findImgByPage(Map<String, Object> map);

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
	 * @Title: findImg   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: TabImg      
	 * @throws   
	 */
	TabImg findImg(Map<String, Object> map);

}
