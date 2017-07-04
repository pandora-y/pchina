package com.pchina.cms.common.utils;

import org.springframework.util.DigestUtils;

public class AuthUtils {

	/**
	 * 生产密文密码
	 * 
	 * @param password
	 *            明文密码
	 * @param email
	 *            邮箱
	 * @return
	 * @throws AuthException
	 */
	public static String getPassword(String password) {
		return DigestUtils.md5DigestAsHex(password.getBytes()).toLowerCase();
	}

	/**
	 * @param str
	 * @return
	 */
	public static String MD5(String str) {
		return DigestUtils.md5DigestAsHex(str.getBytes()).toLowerCase();
	}

	/**
	 * @param email
	 * @return
	 */
//	public static String getFaceUrl(String email) {
//		return SystemConstant.FACE_URL + "/" + AuthUtils.MD5(email) + ".jpg";
//	}
	
	public static void main(String[] args) {
		System.out.println(AuthUtils.getPassword("123456"));
	}
}
