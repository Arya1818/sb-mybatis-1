<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
page rMap : ${pageScope.rMap}<br>
request rMap : ${requestScope.rMap}<br> <!-- requestScope만 찍힘. model은 requestScope만 사용한다 -->
session rMap : ${sessionScope.rMap}<br>
application rMap : ${applicationScope.rMap}<br>

<div class="container">
	<table border="1">
		<tr>
			<th>선택</th>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>비고</th>
		</tr>

		<c:if test="${empty rMap}">
			<tr>
				<td colspan="5">게시물이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="list" items="${rMap.list}" >
			<tr>
				<td><input type="checkbox" name="tiNum" value="${list.tiNum}"></td>
				<td>${list.tiNum}</td>
				<td>${list.tiName}</td>
				<td>${list.tiAddr}</td>
				<td>${list.tiEtc}</td>
			</tr>
		</c:forEach>

	</table>
	<button data-page="insert">게시물작성</button>
	<button onclick="deleteTest()">게시물삭제</button>
</div>


</body>
</html>