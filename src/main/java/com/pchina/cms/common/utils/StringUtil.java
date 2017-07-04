package com.pchina.cms.common.utils;

/**
 * StringUtil:字符串工具类
 * 
 * @author ycjpxj
 *
 */
public class StringUtil {
	/**
	 * 判断是否为空
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		if (s != null && !s.equals("")) {
			return false;
		}
		return true;
	}
}
