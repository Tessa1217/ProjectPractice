<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
	text-align: center;
}

table {
	width: 70%;
	margin: 2.5% auto;
	border: 1px solid #000;
	border-collapse: collapse;
	text-align: center;
}

th, td {
	border: 1px solid #000;
}

tbody tr:hover {
	background: #eee;
	font-weight: bold;
}

</style>
<script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div>
		<div>
			<h1>공지사항 목록</h1>
		</div>
		<div>
			<form id="frm" action="" method="post">
				<select id="key" name="key">
					<option value="1">전체보기</option>
					<option value="2">작성자</option>
					<option value="3">제목</option>
					<option value="4">내용</option>
				</select>&nbsp; 
				<input type="text" id="val" name="val">&nbsp; 
				<input type="button" onclick="search();" value="검색">
			</form>
		</div>
		<br />
		<div>
			<table>
				<thead>
					<tr>
						<th>게시글 번호</th>
						<th>작성자</th>
						<th>제목</th>
						<th>작성일자</th>
						<th>조회수</th>
						<th>썸네일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="notice">
						<tr onclick="noticeSelect()">
							<td>${notice.id}</td>
							<td>${notice.writer}</td>
							<td>${notice.title}</td>
							<td>${notice.wdate}</td>
							<td>${notice.hit}</td>
							<td>${notice.fileName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<button type="button" onclick="location.href='noticeInputForm.do'">글쓰기</button>
		</div>
	</div>
	<script>
		function search() {
			let fields = ['id', 'writer', 'title', 'wdate', 'hit', 'fileName']
			let tbody = document.querySelector('tbody');
			let tr = document.querySelectorAll('tbody > tr');
			tr.forEach((el) => el.remove());
			let body = "key=" + frm.key.value + "&val=" + frm.val.value;
			fetch('noticeSearchList.do', {
				method:'POST',
				headers: {'Content-Type':'application/x-www-form-urlencoded'},
				body: body
			})
			.then(response => response.json())
			.then(data => {
				data.forEach((el) => {
					let tr = document.createElement('tr');
					fields.forEach((val) => {
						let td = document.createElement('td');
						td.innerHTML = el[val];
						if(val == 'id') {
							tr.setAttribute('id', el[val])
							tr.setAttribute('onclick', 'noticeSelect()');
						}
						tr.append(td);
					})
					tbody.append(tr);
				})
				//htmlConvert2(data);
			})
			.catch(err => console.log(err))
			
		}
		
		// jQuery
		function search2() {
			$.ajax({
				url : "noticeSearchList.do",
				type : "post",
				data : {"key":$("#key").val(), "val":$("#val").val()},
				dataType : "json",
				success : function(data){
					//htmlConvert(data);
					htmlConvert2(data);
					},
				error : function(){
						console.log("Error")
				}
			});
		}
		
		function htmlConvert(arr=[]) {
			let fields = ['id', 'writer', 'title', 'wdate', 'hit', 'fileName']
			let tbody = document.querySelector('tbody');
			let tr = document.querySelectorAll('tbody > tr');
			tr.forEach((el) => el.remove());
			arr.forEach((el) => {
				let tr = document.createElement('tr');
				fields.forEach((val) => {
					let td = document.createElement('td');
					td.innerHTML = el[val];
					tr.append(td);
				})
				tbody.append(tr);
			})
		}
		
		// jQuery
		function htmlConvert2(data) {
			$("tbody").remove(); 
			let tbody = $("<tbody/>");
			$.each(data, function(idx, obj) {
				let tr = $("<tr/>").append(
						$("<td/>").text(obj.id),
						$("<td/>").text(obj.writer),
						$("<td/>").text(obj.title),
						$("<td/>").text(obj.wdate),
						$("<td/>").text(obj.hit),
						$("<td/>").text(obj.fileName)
						);
				tbody.append(tr);
			})
			$("table").append(tbody);
		}
	</script>
</body>
</html>