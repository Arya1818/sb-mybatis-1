<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setAttribute("test", "난 jstl이랑 상관없어!");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/tests">테스트리스트</a> <!--  /라고 하면 root에서부터 경로  -->
<a href="naver.com">네이버</a> <!--  상대경로(http://localhost/front/link/naver.com)  , 앵커태그는 무조건 get방식-->
</body>
</html>