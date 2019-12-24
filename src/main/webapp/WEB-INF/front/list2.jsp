<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>비고</th>
		</tr>
		<tbody id=tbody>
		</tbody>
	</table>
	<div id=pagination></div>
</div>

<script>
var rowCount = 10;
$(document).ready(function(){
	goPage(1);
})

function goPage(page){
	$.ajax({
		url:'/tests',
		method:'GET',
		data:'page.page=' + page,
		success:function(res){
			var list = res.list;
			var html = '';
			for(var i=0; i<list.length; i++){
				html += '<tr>';
				html += '<td>' + list[i].tiNum + '</td>';
				html += '<td>' + list[i].tiName + '</td>';
				html += '<td>' + list[i].tiAddr+ '</td>';
				html += '<td>' + list[i].tiEtc+ '</td>';
				html += '</tr>';
			}
			$('#tbody').html(html);
			var totalPage = Math.ceil(res.page.totalCount/)
		}
	})
}
</script>