<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/targetBoard.css">
</head>
<c:import url="/header" />
<body>
	<section id="root">
		<div class="container">
			<h2>제목: ${targetBoard.title}</h2>
			<h4>작성자: ${targetBoard.author}</h4>
			<h4>작성일: ${targetBoard.regWrite}</h4>
			<h4>수정일: ${targetBoard.modWrite}</h4>
			<h4>내용: ${targetBoard.content}</h4>
	
			<c:if test="${targetBoard.id eq user.id || user.id eq 'admin'}">
				<button onClick="location.href='/deleteBoardFormAction'">삭제</button>
				<button onClick="location.href='/updateBoardForm'">수정</button>
			</c:if>
		</div>
	</section>
</body>
<c:import url="/footer" />
</html>