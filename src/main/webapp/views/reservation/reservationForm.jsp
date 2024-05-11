<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<c:import url="/header" />
<body>
	<section id="root">
		<div id="targetCar-info">
			<c:choose>
				<c:when test="${fn:contains(targetCar.carName,'기아')}">
					<img class="logo" src="/resources/image/logo/kia.png" style="height=100px;width:100px;"> 
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'현대')}">
					<img class="logo" src="/resources/image/logo/hyundai.png" style="height=100px;width:100px;"> 
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'쉐보레')}">
					<img class="logo" src="/resources/image/logo/chevrolet.png" style="height=100px;width:100px;">
				</c:when>
			</c:choose>
			
			<c:choose>
				<c:when test="${fn:contains(targetCar.carName,'스파크')}">
					<img class="car-image" src="/resources/image/car/spark.png" style="height=100px;width:100px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'모닝')}">
					<img class="car-image" src="/resources/image/car/morning.png" style="height=100px;width:100px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'레이')}">
					<img class="car-image" src="/resources/image/car/rei.png" style="height=100px;width:100px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'K3')}">
					<img class="car-image" src="/resources/image/car/k3.png" style="height=100px;width:100px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'캐스퍼')}">
					<img class="car-image" src="/resources/image/car/casper.png" style="height=100px;width:100px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'아반떼')}">
					<img class="car-image" src="/resources/image/car/avante.png" style="height=100px;width:100px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'카니발')}">
					<img class="car-image" src="/resources/image/car/carnival.png" style="height=100px;width:100px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'스타리아')}">
					<img class="car-image" src="/resources/image/car/staria.png" style="height=100px;width:100px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'K8')}">
					<img class="car-image" src="/resources/image/car/k8.png" style="height=100px;width:100px;">
				</c:when>
			</c:choose>
			<span class="car-age-passengers-number">${targetCar.carName} ${targetCar.carAge}년식 ○ ${targetCar.passengersNumber}인승</span>
		</div>
		<div id="reservation-info">
			<span>${resevDate} ${resevTime} ~ ${returnDate} ${returnTime} 까지</span>
			<button onclick="location.href='/reservateAction'">예약확정</button>
		</div>
	</section>
</body>
<c:import url="/footer" />
</html>