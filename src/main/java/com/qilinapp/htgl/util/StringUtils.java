/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.util;

import java.util.UUID;

/**    
 * @author：QYW   
 * @since：2019年3月18日上午11:25:31
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public class StringUtils {
	public static boolean equals(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equals(str2);
	}
	
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
