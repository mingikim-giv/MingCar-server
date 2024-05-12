<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/carList.css">
</head>
<c:import url="/header" />
<body>
	<section id="root">
		<form action="/searchCarAction">
			<select name="search-option" id="search-option">
				<option value="car-name">차량명</option>
				<option value="car-seat">인원수</option>
			</select>
			<div id="search-value-container">
				<select name="search-value" id="search-value">
				<option selected disabled>차량크기</option>
				<option value="1001">경형/소형</option>
				<option value="1002">준준형</option>
				<option value="1003">중형</option>
				<option value="1004">준대형</option>
				<option value="1005">대형</option>				
			</select>
			</div>
			<input type="submit" value="검색하기">
		</form>
		<c:set var="gv80Exist" value="${false}"></c:set>
		<c:forEach var="car" items="${carList}">
			<img src="/resources/image/car/gv80.png" style="height=200px; width:300px;" id="logo" onclick="location.href='/targetCar'">
			<div>차량명: ${car.carName}</div>
			<div>가격: ${car.carPrice}원</div>
			<div>차종: ${car.carType}</div>
			<div>인원: ${car.carSeat}인승</div>
			<button onclick="location.href='/targetCarAction?targetCarNum=${car.carCode}'">예약하기</button><br>
		</c:forEach>
	</section>	
</body>
<c:import url="/footer" />
</html>