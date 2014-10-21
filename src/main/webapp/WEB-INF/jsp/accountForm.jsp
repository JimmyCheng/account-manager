<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Create New Record</h1>

<c:url var="saveUrl" value="/account/${action}" />
<form id="inputForm" method="POST" action="${saveUrl}">

		<input type="hidden" name="id" value="${account.id}"/>
		<fieldset>
			<legend><small>Create Account</small></legend>
			<div class="control-group">
				<label for="account_name" class="control-label">Account Name:</label>
				<div class="controls">
					<input type="text" id="account_name" name="name"  value="${account.name}" class="input-large required" minlength="3"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="age" class="control-label">Account Age:</label>
				<div class="controls">
					<input type="text" id="account_age" name="age"  value="${account.age}" class="input-large required" minlength="3"/>
				</div>
			</div>	
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="submit"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="back" onclick="history.back()"/>
			</div>
		</fieldset>
</form>
</body>
</html>