<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>编辑文章</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath }/admin/article/updateJson.action">
	<input type="hidden" value="${article.id }" name="id">
	<label>标题：<input type="text" name="title" value="${article.title }"></label>
	<label>内容：<textarea cols="100" rows="5" name="content">${article.content }</textarea></label>
	<button type="submit">提交</button>
</form>

<script src="${pageContext.request.contextPath }/assets/lib/jquery.js"></script>
<script src="${pageContext.request.contextPath }/assets/lib/util.js"></script>
</body>
</html>