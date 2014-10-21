<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JEE Demo</title>
</head>
<body>
<h1>Accounts</h1>

<c:url var="editImgUrl" value="/resources/img/edit.png" />
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<c:url var="addUrl" value="/account/add" />
<table style="border: 1px solid; width: 100%; text-align:center">
	<thead style="background:#d3dce3">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th colspan="2"></th>
		</tr>
	</thead>
	<tbody style="background:#ccc">
	<c:forEach items="${accounts}" var="account">
		<c:url var="editUrl" value="/account/edit/${account.id}" />
		<c:url var="deleteUrl" value="/account/delete/${account.id}" />
     	<tr>
			<td><c:out value="${account.id}" /></td>
			<td><c:out value="${account.name}" /></td>
			<td><c:out value="${account.age}" /></td>
			<td><a href="${editUrl}"><img src="${editImgUrl}"></img></a></td>
			<td><a href="${deleteUrl}"><img src="${deleteImgUrl}"></img></a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<c:if test="${empty accounts}">
	No records found. 
</c:if>

<p><a href="${addUrl}">Create new record</a></p>
</body>
</html>