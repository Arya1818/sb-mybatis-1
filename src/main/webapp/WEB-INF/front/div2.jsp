<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
		width: 100%;
		height: 300px;
		border: 1px solid #000;
	}
	div.left{
		width: 50%;
		float: left;
		box-sizing: border-box;
		background: #ff0;
	}
	div.right{
		width: 50%;
		float: right;
		box-sizing: border-box;
		background: #0ff;
	}
</style>
</head>
<body>
<select id="page" onchange="changePage(this)">
	<option value="">선택</option>
	<option value="left.jsp">left</option>
	<option value="right.jsp">right</option>
</select>
<div>
		<div class="left">
		<jsp:include page="/${param.page}"></jsp:include>
		</div>
		
		<div class="right">
		<jsp:include page="/${param.page}"></jsp:include>
		</div>
		
	</div>
</body>
<script>
function changePage(f){
	location.href='/div2?page='+ f.value;
}
</script>
</html>