<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/targetCar.css">
</head>
<c:import url="/header" />
<body>
	<section id="root">
		<div id="target-car">
			<c:choose>
				<c:when test="${fn:contains(targetCar.carName,'GV80')}">
					<img class="car-image" src="/resources/image/car/gv80.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'아반떼')}">
					<img class="car-image" src="/resources/image/car/avante.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'쏘나타')}">
					<img class="car-image" src="/resources/image/car/sonata.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'K5')}">
					<img class="car-image" src="/resources/image/car/k5.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'쏘렌토')}">
					<img class="car-image" src="/resources/image/car/sorento.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'모닝')}">
					<img class="car-image" src="/resources/image/car/morning.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'그랜저')}">
					<img class="car-image" src="/resources/image/car/grandeur.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'G80')}">
					<img class="car-image" src="/resources/image/car/g80.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'스포티지')}">
					<img class="car-image" src="/resources/image/car/sportege.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'코나')}">
					<img class="car-image" src="/resources/image/car/kona.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'K8')}">
					<img class="car-image" src="/resources/image/car/k8.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'투싼')}">
					<img class="car-image" src="/resources/image/car/tucson.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'싼타페')}">
					<img class="car-image" src="/resources/image/car/santafe.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'스타리아')}">
					<img class="car-image" src="/resources/image/car/staria.png" style="height=200px;width:300px;">
				</c:when>
				<c:when test="${fn:contains(targetCar.carName,'팰리세이드')}">
					<img class="car-image" src="/resources/image/car/palisade.png" style="height=200px;width:300px;">
				</c:when>
			</c:choose>
			<span class="car-age-passengers-number">차량명: ${targetCar.carName} 차종: ${targetCar.carType} 인원: ${targetCar.carSeat}인승</span>
		</div>
		<div id="reservation-info">
			<form action="/checkReservationAction" id="find-car-by-time">
				<span>대여일</span><input type="date" name="resev-date" id="resev-date" value="${resevDate}"> 
				<select name="resev-time" id="resev-time">
					<option disabled>대여시간 선택</option>
					<option value="07:00:00" ${resevTime eq '07:00:00' ? 'selected':''}>07:00</option>
					<option value="08:00:00" ${resevTime eq '08:00:00' ? 'selected':''}>08:00</option>
					<option value="09:00:00" ${resevTime eq '09:00:00' ? 'selected':''}>09:00</option>
					<option value="10:00:00" ${resevTime eq '10:00:00' ? 'selected':''}>10:00</option>
					<option value="11:00:00" ${resevTime eq '11:00:00' ? 'selected':''}>11:00</option>
					<option value="12:00:00" ${resevTime eq '12:00:00' ? 'selected':''}>12:00</option>
					<option value="13:00:00" ${resevTime eq '13:00:00' ? 'selected':''}>13:00</option>
					<option value="14:00:00" ${resevTime eq '14:00:00' ? 'selected':''}>14:00</option>
					<option value="15:00:00" ${resevTime eq '15:00:00' ? 'selected':''}>15:00</option>
					<option value="16:00:00" ${resevTime eq '16:00:00' ? 'selected':''}>16:00</option>
					<option value="17:00:00" ${resevTime eq '17:00:00' ? 'selected':''}>17:00</option>
					<option value="18:00:00" ${resevTime eq '18:00:00' ? 'selected':''}>18:00</option>
					<option value="19:00:00" ${resevTime eq '19:00:00' ? 'selected':''}>19:00</option>
					<option value="20:00:00" ${resevTime eq '20:00:00' ? 'selected':''}>20:00</option>
					<option value="21:00:00" ${resevTime eq '21:00:00' ? 'selected':''}>21:00</option>
					<option value="22:00:00" ${resevTime eq '22:00:00' ? 'selected':''}>22:00</option>
				</select> 
				<span>반납일</span><input type="date" name="return-date" id="return-date" value="${returnDate}"> 
				<select name="return-time" id="return-time">
					<option disabled >반납시간 선택</option>
					<option value="06:00:00" ${returnTime eq '06:00:00' ? 'selected':''}>06:00</option>
					<option value="07:00:00" ${returnTime eq '07:00:00' ? 'selected':''}>07:00</option>
					<option value="08:00:00" ${returnTime eq '08:00:00' ? 'selected':''}>08:00</option>
					<option value="09:00:00" ${returnTime eq '09:00:00' ? 'selected':''}>09:00</option>
					<option value="10:00:00" ${returnTime eq '10:00:00' ? 'selected':''}>10:00</option>
					<option value="11:00:00" ${returnTime eq '11:00:00' ? 'selected':''}>11:00</option>
					<option value="12:00:00" ${returnTime eq '12:00:00' ? 'selected':''}>12:00</option>
					<option value="13:00:00" ${returnTime eq '13:00:00' ? 'selected':''}>13:00</option>
					<option value="14:00:00" ${returnTime eq '14:00:00' ? 'selected':''}>14:00</option>
					<option value="15:00:00" ${returnTime eq '15:00:00' ? 'selected':''}>15:00</option>
					<option value="16:00:00" ${returnTime eq '16:00:00' ? 'selected':''}>16:00</option>
					<option value="17:00:00" ${returnTime eq '17:00:00' ? 'selected':''}>17:00</option>
					<option value="18:00:00" ${returnTime eq '18:00:00' ? 'selected':''}>18:00</option>
					<option value="19:00:00" ${returnTime eq '19:00:00' ? 'selected':''}>19:00</option>
					<option value="20:00:00" ${returnTime eq '20:00:00' ? 'selected':''}>20:00</option>
					<option value="21:00:00" ${returnTime eq '21:00:00' ? 'selected':''}>21:00</option>
				</select> 
				<input type="submit" value="예약확정" id="resev-time-button">
			</form>
			<button onclick="location.href='/reservationAction'">예약확정</button>
		</div>
	</section>
</body>
<c:import url="/footer" />
</html>