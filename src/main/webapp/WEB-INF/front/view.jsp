<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>게시물 수정</h3>

<table class="table table-bordered">
	<tr>
		<th>번호</th>
		<th>${param.tiNum}</th>
	</tr>
	<tr>
		<th>이름</th>
		<th><input type="text" name="tiName" id="tiName" maxlength="200"></th>
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
		<th colspan="2"><button id="tiUpdate">수정</button></th>
	</tr>
</table>

<script>
var tiNum = '${param.tiNum}'
	$(document).ready(function(){
		$.ajax({
			url:'/tests/view',
			method:'GET',
			data:'tiNum=' + tiNum,
			success:function(res){
				$('#tiName').val(res['tiName']);
				$('#tiAddr').val(res['tiAddr']);
				$('#tiEtc').val(res['tiEtc']);
			}
			
		});
		
		$('#tiUpdate').on('click',function(){
			var data = {
					tiName : document.querySelector('#tiName').value,
					tiAddr : document.querySelector('#tiAddr').value,
					tiEtc : document.querySelector('#tiEtc').value,
			}
			data = JSON.stringify(data);
			$.ajax({
				url:'/tests',
				method:'PUT',
				data:data,
				contentType:'application/json;charset=utf-8',
				success:function(res){
					if(res.result=='false'){
						alert(res.msg);
					}else if(res.result=='true'){
						alert(res.msg);
						console.log(res);
					}
				},
				error:function(res){
					
				}
			})
		})		
		
	})
	
</script>
