<%@page import="com.pchina.cms.core.model.Admin"%>
<%@page import="com.pchina.cms.common.utils.ConstantConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>管理后台</title>
</head>
<body>
<%
	Admin admin = (Admin)session.getAttribute(ConstantConfig.SESSION_ADMIN);
%>
欢迎登陆：<%=admin.getUsername() %>

<a href="${pageContext.request.contextPath }/admin/logout.action">退出登陆</a>
<script src="${pageContext.request.contextPath }/assets/lib/jquery.js"></script>
<script src="${pageContext.request.contextPath }/assets/lib/util.js"></script>

</body>
</html>