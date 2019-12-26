<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
	<table class="table table-hover">
		<tr>
			<th>선택</th>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>비고</th>
		</tr>
		<tbody id="tbody">
		</tbody>
	</table>
	<div id="pagination"></div>
	<button data-page="insert">게시물작성</button>
	<button onclick="deleteTest()">게시물삭제</button>
</div>

<script>
var rowCount = 10;
function deleteTest(){
	var checkedObjs = $('input[type=checkbox]:checked');
	var tiNums = [];
	for(var i=0; i<checkedObjs.length; i++){
		tiNums.push(checkedObjs[i].parentNode.parentNode.childNodes[1].innerText);
	}
	$.ajax({
		url:'/tests',
		method:'DELETE',
		contentType:'application/json;charset=utf-8',
		data:JSON.stringify(tiNums),
		success:function(res){
			console.log(res);
			alert(res.msg);
		}
	})
}



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
			//var tBody = document.getElementById('tbody');
			console.log(list);
			var html = '';
			for(var i=0; i<list.length; i++){
				html += '<tr>';
				html += '<td><input type="checkbox"></td>';
				html += '<td data-page="view">' + list[i].tiNum + '</td>';
				html += '<td>' + list[i].tiName + '</td>';
				html += '<td>' + list[i].tiAddr+ '</td>';
				html += '<td>' + list[i].tiEtc+ '</td>';
				html += '</tr>';
			}
			//tbody.innerHTML = html;
			$('#tbody').html(html);
			var totalPage = Math.ceil(res.page.totalCount/rowCount); //올림
			var sPage = Math.floor((res.page.page-1)/10)*10+1; //sPage는 첫페이지
			var ePage = sPage + 9;
			if(ePage>totalPage){
				ePage = totalPage;
			}
			var html = '';
			if(sPage!=1){
				html = '<a data-page="1">◀</a>';
			}
			for(var i=sPage; i<=ePage; i++){
				if(i==res.page.page){
					html+='<b> [ '+i+' ]</b>';
				}else{
					html += '<a data-page="'+ i +'"> [ '+i+' ]</a>';
				}
			}
			if(ePage!=totalPage){
				html += '<a data-page="'+ (sPage+10)+'">▶</a>';
			}
		
			$('#pagination').html(html);
			setEvent();
		}
	})
}

function setEvent(){
	$('a[data-page]').on('click',function(){
		goPage(this.getAttribute('data-page'));
	})
	$('td[data-page]').on('click',function(){
		location.href = '/?page='+ this.getAttribute('data-page') + '&tiNum=' + this.innerText;
	})

}

</script>