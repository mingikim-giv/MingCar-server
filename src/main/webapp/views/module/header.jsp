<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="https://cdn-icons-png.freepik.com/256/6301/6301186.png?ga=GA1.1.283867284.1714552356&semt=ais_hybrid">
<link rel="stylesheet" href="/resources/style/grid.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Ming Car</title>
</head>
<body>
	<header>
		<div id="top">
			<h1><a href="/">Ming Car</a></h1>
			<nav>
				<ul>
					<li><a href="/mypage">마이 페이지</a></li>
					<li><a href="about:blank">예약</a></li>
					<li><a href="about:blank">게시판</a></li> 
				</ul>
			</nav>
			<ul>
				<c:choose>
					<c:when test="${not empty sessionScope.user}">
						<li><a href="/logout"><span>로그아웃</span></a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/login"><span>로그인</span></a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="/join">회원가입</a></li>
			</ul>
		</div>
	</header>
</body>
</html>