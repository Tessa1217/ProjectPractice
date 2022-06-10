<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	width: 80%;
	padding: 0;
	margin: 0 auto;
	padding: 0;
}

div {
	text-align: center;
}

#frm {
	text-align: center;
	padding: 0;
	margin: 0;
	width: 100%;
}

table {
	width: 60%;
	margin: 0 auto;
	border: 1px solid #000;
	border-collapse: collapse;
	border: 1px solid #000;
}

th, td {
	border: 1px solid #000;
	padding: 10px;
}

td>input[type="text"] {
	width: 90%;
}

th {
	width: 100px;
}
</style>
</head>
<body>
	<div>
		<h1>공지사항 등록</h1>
	</div>
	<div>
		<form id="frm" action="noticeInput.do" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" id="writer" name="writer"></td>
					<th>작성일자</th>
					<td><input type="date" id="wdate" name="wdate"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan=3><input type="text" id="title" name="title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan=3><textarea cols="80" rows="10" id="subject"
							name="subject"></textarea></td>
				</tr>
				<tr>
					<th>파일</th>
					<td colspan=3><input type="file" id="fileName" name="fileName"></td>
				</tr>
			</table>
			<br />
			<div>
				<input type="submit" value="저장">&nbsp;&nbsp; <input
					type="reset" value="취소">&nbsp;&nbsp; <input type="button"
					value="목록가기" onclick="location.href='noticeList.do'">
			</div>
		</form>
	</div>

</body>
</html>