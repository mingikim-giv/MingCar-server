<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/mypage.css">
</head>
<c:import url="/header" />
<body>
	<section id="root">
		<img src="https://em-content.zobj.net/source/microsoft-teams/363/bust-in-silhouette_1f464.png">
		<h1>${user.name}님 환영합니다!</h1>
		
		<button onclick="location.href='/updateUser'">회원정보 수정</button>
		<button onclick="location.href='/deleteUserForm'">회원 탈퇴</button>
		<h3>예약 현황</h3>
			<table>
				<thead>
					<tr>
						<th>예약 코드</th>
						<th>차량 코드</th>
						<th>대여 날짜</th>
						<th>반납 일자</th>
						<th>결재 방법</th>
						<th>예약 변경</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="reserve" items="${reserveList }">
						<tr>
							<td>${reserve.reserveCode}</td>
							<td>${reserve.carCode}</td>
							<td>${reserve.startDate}</td>
							<td>${reserve.endDate}</td>
							<td>${reserve.paymentMethod}</td>
		                	<td>
		                		<button onclick="location.href='/updateReservationAction?reCode=${reserve.reserveCode}'">수정</button>
		                		<button onclick="location.href='/deleteReservationAction?reCode=${reserve.reserveCode}'">예약 취소</button>
		                	</td>
		                </tr>
					</c:forEach>
				</tbody>
			</table>
	</section>
</body>
<c:import url="/footer" />
</html>