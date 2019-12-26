<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>게시물 작성</h3>
<!-- 
이름 : 2글자 이상 100글자 이하 ,null불가 
주소 : 10글자 이상 200글자 이하,null불가
비고 : 1000글자 이하, null가능
-->

<table class="table table-bordered">
	<tr>
		<th>이름</th>
		<th><input type="text" name="tiName" id="tiName" maxlength="10"></th>
	</tr>
	<tr>
		<th>주소</th>
		<th><input type="text" name="tiAddr" id="tiAddr" maxlength="200"></th>
	</tr>
	<tr>
		<th>비고</th>
		<th><textarea name="tiEtc" id="tiEtc" cols=30 rows=10 maxlength="1000"></textarea></th>
	</tr>
	<tr>
		<th colspan="2"><button id="tiInsert">등록</button></th>
	</tr>
</table>

<script>
$(document).ready(function(){
	$('#tiInsert').on('click',function(){
		var data = {
				tiName : document.querySelector('#tiName').value,
				tiAddr : document.querySelector('#tiAddr').value,
				tiEtc : document.querySelector('#tiEtc').value,
		}
		data = JSON.stringify(data);
		$.ajax({
			url:'/tests',
			method:'POST',
			data:data,
			contentType:'application/json;charset=utf-8',
			success:function(res){
				if(res==''){
					alert('게시물 등록 실패');
				}else{
					alert('게시물 등록 완료');
					console.log(res);
				}
			},
			error:function(res){
				console.log(res);
			}
		})
		
	})
})
</script>
