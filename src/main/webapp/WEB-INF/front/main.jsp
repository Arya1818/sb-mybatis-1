<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
param-page = ${param.page}<br> <!-- request.getParameter("page") 와 같음, 키값에 뭐가 없음면 null나옴 -->

<select id="page" onchange="changePage(this)">
	<option value="">선택</option>
	<option value="right1.jsp">라이트1</option>
	<option value="right2.jsp">라이트2</option>
</select><br>

<c:if test="${not empty param.page}">
	<jsp:include page="/WEB-INF/front/include/${param.page}"></jsp:include> <!-- main으로 들어갔지만 right1이 안보이는 상태. -->
</c:if>

<script>
function changePage(f){
	location.href='/front/include/main?page=' + f.value;
}
window.onload = function(){
	var page = '${param.page}';
	if(page){
		document.querySelector('#page').value = page;
	}
}
</script>
</body>
</html>