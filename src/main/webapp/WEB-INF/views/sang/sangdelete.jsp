<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="sdelete2" method="post">
<input type="number" name="snum" value="${dto.snum}">
<input type="text" name="sname" value="${dto.sname}">
<input type="hidden" name="simage" value="${dto.simage}">

<p>${dto.sname} 을(를) 정말 삭제하시나용?</p>
<input type="submit" value="전송">
<input type="button" value="취소" onclick="location.href='out'">

</form>
</body>
</html>