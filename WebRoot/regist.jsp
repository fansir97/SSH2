<%-- <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>  
	<body>	
        <div class="wrap">
            <div class="guimeilogo"></div>
            <div class="register">
            <div class="top">
            <h1>新用户注册</h1>
            <a href="/SSH2/Login.jsp">已有账号</a></div>
            <div class="mid">
            <div style="color: red">${error}</div>
            <form action="regist.action" method="post">
            <input type="text" name="username" id="username" placeholder="用户名" required="required"/><br/><br/>
             <input type="password" name="password" id="password" placeholder="密码" required="required" /><br/><br/>
             <input type="password" name="reppw" id="reppw" placeholder="重复密码" required="required" /><br/><br/>
             <input type="submit" id="submit" value="注册"/>
             </form>
             </div>
             </div>
        </div>
<!--     <script>
        if ("${success}"=="注册成功"){
            if(confirm("注册成功，是否登录？")){
                window.location.href="/ssh/login.jsp";
            }
        }
    </script> -->
    </body>
</html>
 --%>
 
 
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户注册</title>
</head>
<body>
	<h1>用户注册</h1>
	<s:fielderror></s:fielderror>
	<s:form action="regist" method="post">
		<s:textfield name="username" label="用户名" />
		<s:password name="password" label="密码" />
		<s:password name="repassword" label="确认密码"></s:password>
		<s:submit value="提交" />
		</s:form>
	<a href="<%=request.getContextPath()%>/Login.jsp">已有账号</a>

</body>
</html>