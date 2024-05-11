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
		<div id="target-car">
			<c:choose>
				<c:when test="${fn:contains(targetCar.carName,'GV80')}">
					<img class="car-image" src="/resources/image/car/gv80.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'아반떼')}">
					<img class="car-image" src="/resources/image/car/avante.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'쏘나타')}">
					<img class="car-image" src="/resources/image/car/sonata.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'K5')}">
					<img class="car-image" src="/resources/image/car/k5.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'쏘렌토')}">
					<img class="car-image" src="/resources/image/car/sorento.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'모닝')}">
					<img class="car-image" src="/resources/image/car/morning.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'그랜저')}">
					<img class="car-image" src="/resources/image/car/grandeur.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'G80')}">
					<img class="car-image" src="/resources/image/car/g80.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'스포티지')}">
					<img class="car-image" src="/resources/image/car/sportege.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'코나')}">
					<img class="car-image" src="/resources/image/car/kona.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'K8')}">
					<img class="car-image" src="/resources/image/car/k8.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'투싼')}">
					<img class="car-image" src="/resources/image/car/tucson.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'싼타페')}">
					<img class="car-image" src="/resources/image/car/santafe.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'스타리아')}">
					<img class="car-image" src="/resources/image/car/staria.png" style="height=200px;width:200px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'펠리세이드')}">
					<img class="car-image" src="/resources/image/car/palisade.png" style="height=200px;width:200px;">
				</c:when>
			</c:choose>
			<span class="car-age-passengers-number">${targetCar.carName} ${targetCar.carType} ○ ${targetCar.carSeat}인승</span>
		</div>
		<div id="reservation-info">
			<span>${startDate} ~ ${endDate} 까지</span>
			<button onclick="location.href='/reservateAction'">예약확정</button>
		</div>
	</section>
</body>
<c:import url="/footer" />
</html>