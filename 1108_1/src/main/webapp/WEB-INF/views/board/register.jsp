<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>register</h1>

	<form:form method="POST" modelAttribute="vo">
		<p>
			<input name="title" type="text">
			<form:errors path="title"></form:errors>
		</p>
		<p>
			<input name="content" type="text">
			<form:errors path="content"></form:errors>
		</p>
		<p>
			<input name="writer" type="text">
		</p>
		<p>
			<button>버 튼</button>
		</p>
	</form:form>
</body>
</html>