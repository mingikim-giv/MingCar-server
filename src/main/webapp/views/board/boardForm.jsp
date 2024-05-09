<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<c:import url="/header" />
<body>
	<section id="root">
		<div>
			<h2>게시판</h2>
			<div>
				<input type="text" id="inpSearch" placeholder="검색어를 입력해주세요." title="검색어를 입력해주세요.">
			</div>
			<p id="index"><span>작성자명</span><span>제목</span></p>
			<c:forEach var="board" items="${boardlist}">
				<c:if test="${board.category ne true}">
					<h4>${board.id}</h4>
				</c:if>
			</c:forEach>
		</div>
		<c:if test="${not empty user}">
			<button onClick="location.href='/createBoardForm'">글쓰기</button>
		</c:if>
	</section>
</body>
<c:import url="/footer" />
</html>