package com.pchina.cms.common.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pchina.cms.common.utils.ConstantConfig;



public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	/**  
	 * 创建一个新的实例 AuthInterceptor.  
	 *    
	 */
	public AuthInterceptor() {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Integer uid = (Integer) request.getSession().getAttribute(ConstantConfig.UID);
		if (null == uid) {
			if (this.isAjax(request)) {
				// ajax
				response.setCharacterEncoding("UTF-8");
				response.sendError(HttpServletResponse.SC_FORBIDDEN, "您好，您暂无操作此功能的权限，如要操作请联系管理员，谢谢!");
			} else {
				response.sendRedirect(request.getContextPath() + "/admin/login?backUrl=" + request.getRequestURI());
			}
			return false;
		}
		return true;
	}

	public boolean isAjax(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null 
				&& requestType.equalsIgnoreCase("XMLHttpRequest")) {
			//如果是ajax请求响应头会有x-requested-with 
			return true;
		}
            
		return false;
	}
}
