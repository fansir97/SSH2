<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'dispcart.jsp' starting page</title>

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
	<h1>购物车</h1>
	<table border=1>
		<tr>
			<td>产品id</td>
			<td>产品名称</td>
			<td>类别名称</td>
			<td>单位数量</td>
			<td>单价</td>
			<td>数量</td>
			<td>小计</td>
			<td>删除</td>
		</tr>
		<form name=ff action="shop!updatecart.action" method="post">
			<c:forEach var="prod" items="${cart.map}">
				<tr>
					<td>${prod.key }<input type=hidden name=productid
						value="${prod.key }"></td>
					<td>${prod.value.product.productName }</td>
					<td>${prod.value.product.categories.categoryName }</td>
					<td>${prod.value.product.quantityPerUnit }</td>
					<fmt:formatNumber var="price"
						value="${prod.value.product.unitPrice }" pattern="0.00" />
					<td align=right>${price }</td>
					<td align=center><input type=text name=sl
						value="${prod.value.sl }" size=5 onblur="return checksl(this)"></td>
					<fmt:formatNumber var="xiaoji" value="${prod.value.xiaoji }"
						pattern="0.00" />
					<td align=right>${xiaoji }</td>
					<td><a href="shop!delete.action?prodid=${prod.key }">删除</a></td>
				</tr>
			</c:forEach>
		</form>
		<fmt:formatNumber var="total" value="${cart.total }" pattern="0.00" />
		<tr>
			<td colspan=6>总金额</td>
			<td>${total }</td>
			<td></td>
		</tr>
	</table>
	<a href="shop!clear.action">清空购物车</a>&nbsp;
	<a href="shop!select.action">继续购物</a>&nbsp;
	<c:if test="${cart.total>0}">
		<a href="javascript:document.ff.submit()">修改购物车</a>&nbsp;
<a href="shop!service.action">去服务台结账</a>&nbsp;
</c:if>
</body>
</html>
<script>
	function checksl(obj) {
		var pattern = /^[1-9]\d*$/;
		if (!pattern.test(obj.value)) {
			alert("必须是正整数");
			obj.focus();
			return false;
		}
		return true;
	}
</script>