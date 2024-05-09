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
		<div>
			<h2>제목: ${targetBoard.title}</h2>
			<h2>제목: ${targetBoard.content}</h2>
		</div>
	</section>
</body>
<c:import url="/footer"></c:import>
</html>