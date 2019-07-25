/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**    
 * @author：QYW   
 * @since：2019年3月19日上午9:40:49
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public class TimeUtils {
	public static String getTime() {
		Calendar c = Calendar.getInstance();    
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");    
        String time = String.valueOf(f.format(c.getTime()));
        return time;
	}
	public static String wdatePickerFormat(String str) {
		if(str != null) {
			str = str.replace("-", "");
			str = str.replace(":", "");
			str = str.replace(" ", "");
		}
		return str;
	}
public static void main(String[] args) {
	String str = "2019-03-20 17:15:06";
	
	System.err.println(wdatePickerFormat(str));
}	
	
}
