<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'service.jsp' starting page</title>

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
	<h1>服务台</h1>
	<table border=1>
		<tr>
			<td>产品id</td>
			<td>产品名称</td>
			<td>类别名称</td>
			<td>单位数量</td>
			<td>单价</td>
			<td>数量</td>
			<td>小计</td>
		</tr>
		<c:forEach var="prod" items="${cart.map}">
			<tr>
				<td>${prod.key }</td>
				<td>${prod.value.product.productName }</td>
				<td>${prod.value.product.categories.categoryName}</td>
				<td>${prod.value.product.quantityPerUnit }</td>
				<fmt:formatNumber var="price"
					value="${prod.value.product.unitPrice }" pattern="0.00" />
				<td align=right>${price }</td>
				<td align=center>${prod.value.sl }</td>
				<fmt:formatNumber var="xiaoji" value="${prod.value.xiaoji }"
					pattern="0.00" />
				<td align=right>${xiaoji }</td>
			</tr>
		</c:forEach>
		<fmt:formatNumber var="total" value="${cart.total }" pattern="0.00" />
		<tr>
			<td colspan=6>总金额</td>
			<td>${total }</td>
		</tr>
	</table>
	<a href="shop!saveorder.action">保存订单</a>
</body>
</html>
