<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/createBoard.css">
</head>
<c:import url="/header" />
<body>
	<form method="POST" action="/createBoardFormAction">
		<input type="text" name="title" id="title" placeholder="제목"><br>
		<input type="text" name="content" id="content" placeholder="내용"><br>
		<input type="submit" value="등록하기">
	</form>
</body>
<c:import url="/footer" />
</html>