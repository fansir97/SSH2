<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'Login.jsp' starting page</title>
</head>
<body>
	<h1>用户登录</h1>
	<s:form action="shop!login" method="post">
		<s:textfield name="username" label="用户名" />
		<s:password name="userpass" label="密码" />
		<s:submit value="登录" />

		</s:form>
	<a href="<%=request.getContextPath()%>/regist.jsp">注册</a>

</body>
</html>