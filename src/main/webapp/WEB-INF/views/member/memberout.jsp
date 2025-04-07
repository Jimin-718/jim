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
<table border="1" width="650px" align="center">
<caption>회원자료 출력화면</caption>
    <tr>
      <th>아이디</th><th>비밀번호</th><th>이름</th>
    </tr>
    <c:forEach items= "${list }" var="my">
    <tr>
       <td>${my.id }</td>
       <td>${my.pw }</td>
       <td>${my.name }</td>  
    </tr>
    </c:forEach>

</table>
</body>
</html>