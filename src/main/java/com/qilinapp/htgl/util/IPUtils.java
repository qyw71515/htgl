/** 
 * Copyright: Copyright (c)2015
 * Company: 江西航天信息有限公司(jxhtxx.com) 
 */
package com.qilinapp.htgl.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**    
 * @author：QYW   
 * @since：2019年3月19日上午9:42:56
 * @description:
 * @version: 1.0  
 * @copyright: Copyright (c)2015
 * @company: 江西航天信息有限公司(jxhtxx.com) 
 */
public class IPUtils {
public static String getUserIpAdress() {
	InetAddress address;
	String ipdz = "";
	try {
		address = InetAddress.getLocalHost();
		ipdz = address.getHostAddress();
	} catch (UnknownHostException e) {
		e.printStackTrace();
	}
	return ipdz;
}
}
