<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/updateBoard.css">
</head>
<c:import url="/header" />
<body>
	<form method="POST" action="/updateBoardFormAction">
		<input type="text" name="title" id="title" value="${targetBoard.title}"><br>
		<input type="text" name="content" id="content" value="${targetBoard.content}"><br>
		<input type="submit" value="수정하기">
	</form>
</body>
<c:import url="/footer" />
</html>