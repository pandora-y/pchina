<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登陆页面</title>
</head>
<body>
<form id="js-login-form" action="javascript:;">
	<label>用户名：<input type="text" name="username"></label>
	<label>密码：<input type="password" name="password"></label>
	<button type="button" id="js-login">提交</button>
</form>

<script src="${pageContext.request.contextPath }/assets/lib/jquery.js"></script>
<script src="${pageContext.request.contextPath }/assets/lib/util.js"></script>
<script>
	$(function() {
		$('#js-login').on('click', function() {
			$.ajax({
				url: '${pageContext.request.contextPath }/admin/loginJson.action',
				data: $('#js-login-form').serializeToJson(),
				type: 'post',
				success: function(rs) {
					if (rs.result) {
						window.location.href='${pageContext.request.contextPath }/jsp/admin/index.jsp';
					}
				}
			});
		});
	});
</script>
</body>
</html>