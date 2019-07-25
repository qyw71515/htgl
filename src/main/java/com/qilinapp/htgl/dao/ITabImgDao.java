/** 
 * Copyright: Copyright (c)2015
 * Company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
package com.qilinapp.htgl.dao;

import java.util.List;
import java.util.Map;

import com.qilinapp.htgl.model.TabImg;

/**    
 * @author��QYW   
 * @since��2019��4��4������11:31:17
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: ����������Ϣ���޹�˾(jxhtxx.com) 
 */
public interface ITabImgDao {

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
	 * @Title: findImg   
	 * @Description: 
	 * @param: @param map
	 * @param: @return      
	 * @return: TabImg      
	 * @throws   
	 */
	TabImg findImg(Map<String, Object> map);

}
