package com.pchina.cms.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pchina.cms.common.utils.AuthUtils;
import com.pchina.cms.common.utils.CmsException;
import com.pchina.cms.common.utils.ConstantConfig;
import com.pchina.cms.common.utils.PropertyUtils;
import com.pchina.cms.common.utils.StringUtil;
import com.pchina.cms.core.dao.AdminMapper;
import com.pchina.cms.core.model.Admin;
import com.pchina.cms.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminDao;
	public void adminLogin(String username, String password, HttpServletRequest request) throws Exception {
		if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
			throw new CmsException(PropertyUtils.getValue("USER_AND_PASSWORD_NULL"));
		}
		String loginPassword = AuthUtils.getPassword(password);
		Admin admin = adminDao.findByAdmin(username);
		if (admin != null && loginPassword.equals(admin.getPassword())) {
			admin.setPassword("");
			HttpSession session = request.getSession();
			session.setAttribute(ConstantConfig.SESSION_ADMIN, admin);
		} else {
			throw new CmsException(PropertyUtils.getValue("USER_AND_PASSWORD_ERROR"));
		}
	}

}
