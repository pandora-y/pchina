package com.pchina.cms.service;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {
	public void adminLogin(String username, String password, HttpServletRequest request) throws Exception;
}
