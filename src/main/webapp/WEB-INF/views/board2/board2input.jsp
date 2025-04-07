<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="board2save" method="post">
	<table border="3" width="400px" align="center">
	<caption>Q&A 글 올리기</caption>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="boardwriter"></td>
	</tr>
	<tr>
		<th>글제목</th>
		<td><input type="text" name="boardtitle"></td>
	</tr>
	<tr>
		<th>글내용</th>
		<td>
			<textarea rows="10" cols="30" name="boardcontent"></textarea>
		</td>

	</tr>
	<tr style="text-align: center;">
		<td colspan="2">
			<input type="submit" value="작성글저장">
			<input type="button" value="취소..메인" onclick="location.href='./'">
		</td>
	</tr>
	
	
	
	</table>
</form>
</body>
</html>