<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="4" width="800px" align="center">
<caption>게시판 전체글보기</caption>
	<tr>
		<th>글번호</th>
		<th>글제목</th>
		<th>글작성자</th>
		<th>작성일자</th>
		<th>조회수</th>
		<th>groups</th>
		<th>step</th>
		<th>indent</th>		
	</tr>
	<c:forEach items="${list}" var="my">
	<tr>
		<td>${my.boardnumber}</td>
		<td style="text-align: left;">
		<c:forEach var="i" begin="0" end="${my.indent }">
		  &emsp;
		</c:forEach>
		<a href="detail?bnum=${my.boardnumber}">
		${my.boardtitle}
		</a>
		</td>
		<td>${my.boardwriter}</td>
		<td>${my.boarddate}</td>
		<td>${my.boardreadcnt}</td>
		<td>${my.groups}</td>
		<td>${my.step}</td>
		<td>${my.indent}</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>