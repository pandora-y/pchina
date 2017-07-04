package com.pchina.cms.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pchina.cms.common.utils.JsonVo;
import com.pchina.cms.core.model.Admin;
import com.pchina.cms.service.AdminService;

@Controller
@RequestMapping("/admin/")
public class LoginController {
	@Autowired
	private AdminService adminService;
	
	@ResponseBody
	@RequestMapping(value="loginJson", method=RequestMethod.POST)
	public JsonVo<String> login(HttpServletRequest request, Admin admin) {
		JsonVo<String> jsonVo = new JsonVo<String>();
		try {
			adminService.adminLogin(admin.getUsername(), admin.getPassword(), request);
			jsonVo.setResult(true);
		} catch (Exception e) {
			jsonVo.setMsg(e.getMessage());
			jsonVo.setResult(false);
		}
		return jsonVo;
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			session.invalidate();
		} catch (Exception e) {
			
		}
		return "redirect:/jsp/admin/login.jsp";
	}
}
