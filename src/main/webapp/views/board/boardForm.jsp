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
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${boardlist}">
						<tr>
							<td><a href="/targetBoardAction?boardCode=${board.boardCode}">${board.title}</a></td>
							<td>${board.id}</td>
							<td>${board.regWrite}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<c:if test="${not empty user}">
			<button onClick="location.href='/createBoardForm'">글쓰기</button>
		</c:if>
	</section>
</body>
<c:import url="/footer" />
</html>