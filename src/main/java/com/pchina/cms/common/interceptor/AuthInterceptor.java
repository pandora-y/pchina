package com.pchina.cms.common.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pchina.cms.common.utils.ConstantConfig;
import com.pchina.cms.core.model.Resource;



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
		String servletPath = request.getServletPath();
		System.out.println("拦截器："+servletPath);
		Integer uid = (Integer) request.getSession().getAttribute(ConstantConfig.UID);
		if (null == uid) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		if ("/welcome".equalsIgnoreCase(servletPath)) {
			return true;
		}
		List<Resource> urlResources = (List<Resource>) request.getSession().getAttribute(ConstantConfig.USER_URL_RESOURCES);
		for (Resource resource : urlResources) {
			if (resource.getUri().indexOf(";") > -1) {
				String[] uriArray = resource.getUri().split(";");
				for (String uri : uriArray) {
					if (servletPath.indexOf(uri) > -1) {
						if (resource.getType() == 2) {
							request.setAttribute("current_twomenu_id", resource.getPid() != null ? resource.getPid() : 0);
							Integer twoMenuPid = null;
							for (Resource resource2 : urlResources) {
								if (resource2.getType() == 1 && resource2.getId() == resource.getPid()) {
									twoMenuPid = resource2.getPid();
									break;
								}
							}
							request.setAttribute("current_onemenu_id", twoMenuPid != null ? twoMenuPid : 0);
						} else {
							request.setAttribute("current_twomenu_id", resource.getId() != null ? resource.getId() : 0);
							request.setAttribute("current_onemenu_id", resource.getPid() != null ? resource.getPid() : 0);
						}
						return true;
					};
				}
			} else {
				if (servletPath.indexOf(resource.getUri()) > -1) {
					if (resource.getType() == 2) {
						request.setAttribute("current_twomenu_id", resource.getPid() != null ? resource.getPid() : 0);
						Integer twoMenuPid = null;
						for (Resource resource2 : urlResources) {
							if (resource2.getType() == 1 && resource2.getId() == resource.getPid()) {
								twoMenuPid = resource2.getPid();
								break;
							}
						}
						request.setAttribute("current_onemenu_id", twoMenuPid != null ? twoMenuPid : 0);
					} else {
						request.setAttribute("current_twomenu_id", resource.getId() != null ? resource.getId() : 0);
						request.setAttribute("current_onemenu_id", resource.getPid() != null ? resource.getPid() : 0);
					}
					return true;
				};
			}
		}
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "您好，您暂无操作此功能的权限，如要操作请联系管理员，谢谢!");
		return false;
	}

}
