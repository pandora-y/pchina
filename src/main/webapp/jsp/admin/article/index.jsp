<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="page" uri="http://www.ibingo.net.cn/tags/pagination"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户列表</title>
<jsp:include page="../common/style.jsp"></jsp:include>

</head>
<body style="padding: 20px;">
<div class="toolbar">
	<div class="btn-toolbar">
	  <div class="btn-group">
	    <a class="btn" href="${pageContext.request.contextPath }/admin/article/add">新增</a>
	    <a class="btn" href="#"><i class="icon-align-center"></i></a>
	    <a class="btn" href="#"><i class="icon-align-right"></i></a>
	    <a class="btn" href="#"><i class="icon-align-justify"></i></a>
	  </div>
	</div>
</div>
<table class="table table-hover table-bordered table-striped table-condensed flip-content">
	<thead  class="flip-content bordered-palegreen">
		<tr>
			<th>标题</th>
			<th>内容</th>
			<th>时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<c:forEach items="${pageDataList.pageRecords }" var="article">
	<tr>
		<td>${article.title }</td>
		<td>${article.content }</td>
		<td><fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td><a href="${pageContext.request.contextPath }/admin/article/update?id=${article.id}">修改</a> | <a href="${pageContext.request.contextPath }/admin/article/deleteJson.action?id=${article.id}">删除</a></td>
	</tr>
	</c:forEach>
</table>

<div class="footer">
      <!-- 分页  -->
	<c:url var="pageUrl" value="/admin/article/list">
		<c:param name="keyword" value="${param.keyword}" />
	</c:url>
	<page:pagerNav modelRef="pageDataList" url="${pageUrl }" type="beyond" />
</div>
</body>
</html>