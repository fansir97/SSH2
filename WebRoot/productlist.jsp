<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'productlist.jsp' starting page</title>
</head>
<body>
	<h1>产品目录</h1>
	<table border=1>
		<tr>
			<td>产品id</td>
			<td>产品名称</td>
			<td>类别名称</td>
			<td>单位数量</td>
			<td>单价</td>
			<td>购买</td>
		</tr>
		<c:forEach var="t" items="${pb.data}" varStatus="s">
			<form action="shop!add.action" method="post">
				<tr>
					<td>${t.productId }<input type=hidden name=prodid
						value="${t.productId }"></td>
					<td>${t.productName }</td>
					<td>${t.categories.categoryName }</td>

					<td>${t.quantityPerUnit }</td>
					<fmt:formatNumber var="price" value="${t.unitPrice}" pattern="0.00" />
					<td align=right>${price }</td>
					<td><a href="javascript:document.forms[${s.index }].submit()">添加到购物车
					</a></td>
				</tr>
			</form>
		</c:forEach>
	</table>
	<c:forEach var="i" begin="1" end="${pb.allpage}">
		<c:if test="${i==pb.pagecode}">${i }</c:if>
		<c:if test="${i!=pb.pagecode}">
			<a href="javascript:gopage(${i })">${i }</a>
		</c:if>
	</c:forEach>
	<form name=pageform action="shop!select.action" method=post>
		<input type=hidden name="pagecode">
	</form>
</body>
</html>
<script>
	function gopage(i) {
		document.pageform.pagecode.value = i;
		document.pageform.submit();
	}
</script>