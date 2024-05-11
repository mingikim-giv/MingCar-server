<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<c:import url="/header" />
<body>
	<c:choose>
		<c:when test="${isReservation}">
			<script type="text/javascript">
				alert('예약이 완료되었습니다.');
				window.location = '/';
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert('예약이 실패되었습니다.');
				window.location = '/';
			</script>			
		</c:otherwise>
	</c:choose>
</body>
<c:import url="/footer" />
</html>