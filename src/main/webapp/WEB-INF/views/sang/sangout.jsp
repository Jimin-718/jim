<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="400px" align="center">
<caption>상품정보출력폼</caption>
<tr>
<th>상품번호</th><th>상품이름</th><th>상품사진</th><th>비고</th>
</tr>

<c:forEach items="${list}" var="my">
<tr>
<td>${my.snum}</td>
<td>${my.sname}</td>
<td><img alt="" src="./image/${my.simage}" width="40px" height="40px"></td>
<td><a href="sdelete?snum=${my.snum}">삭제</a>
<a href="supdate?snum=${my.snum}">수정</a></td>
</tr>

</c:forEach>


</table>
</body>
</html>