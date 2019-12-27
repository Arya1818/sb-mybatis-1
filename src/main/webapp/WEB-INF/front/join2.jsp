<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/front/join2" onsubmit="return joinCheck()">
<table border="1" >
	<tr>
		<th>이름</th>
		<td><input type="text" name="uiName" id="uiName"></td>
	</tr>
	<tr>
		<th>아이디</th>
		<td><input type="text" name="uiId" id="uiId"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="uiPwd" id="uiPwd"></td>
	</tr>
	<tr>
		<th colspan="2"><button>회원가입</button></th>
	</tr>

</table>
</form>

<script>
function joinBtn(){
	var uiNameObj = document.querySelector('uiName');
	if(uiName.value.trim().length<2){
		alert("이름은 2글자 이상입니다");
		uiNameObj.value='';
		uiNameObj.focus();
		return false;
	}
	var uiIdObj = document.querySelector('uiId');
	if(uiId.value.trim().length<5){
		alert('아이디는 5글자 이상입니다');
		uiIdObj.value='';
		uiIdObj.focus();
		return false;
	}
	return true;
}
</script>
</body>
</html>