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
		<c:set var="gv80Exist" value="${false}"></c:set>
		<c:forEach var="car" items="${carList}">
			<img src="/resources/image/car/gv80.png" style="height=200px; width:200px;" id="logo" onclick="location.href='/carFormAction'">
			<div>${car.carName}</div>
			<div>${car.carPrice}</div>
			<div>${car.carType}</div>
			<div>${car.carSeat}인승</div>
			<button>예약하기</button><br>
		</c:forEach>
	</section>	
</body>
<c:import url="/footer" />
</html>