<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<c:import url="/header"></c:import>
<body>
	<section id="root">
		<div class="container">
			<h4>작성일 : ${targetBoard.regWrite}		수정일 : ${targetBoard.modWrite}</h4>
			<h2>제목 : ${targetBoard.title} 작성자 : ${targetBoard.author}</h2>
			<h3>내용 : ${targetBoard.content}</h3>
	
			<c:if test="${targetBoard.id eq user.id || user.id eq 'admin'}">
				<button onClick="location.href='/deleteBoardAction'">삭제</button>
				<button onClick="location.href='/updateBoard'">수정</button>
			</c:if>
		</div>
	</section>
</body>
<c:import url="/footer"></c:import>
</html>