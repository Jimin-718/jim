<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="supdate2" method="post" enctype="multipart/form-data">
<input type="hidden" name="old" value="${dto.simage }">
<table border="1" width="400px" align="center">
<caption>상품정보수정폼</caption>


<tr>
  <th>상품번호</th>
  <td><input type="number" name="snum" value="${dto.snum}" readonly></td>
</tr>
<tr>
  <th>상품이름</th>
  <td><input type="text" name="sname" value="${dto.sname}"></td>
</tr>
<tr>
  <th>상품이미지</th>
  <td><input type="file" name="simage" >
  
  
  </td>
  
</tr>


<tr>
  <td colspan="2">
  <input type="submit" value="전송">
  <input type="reset" value="취소">
  </td>
</tr>

</table>



</form>
</body>
</html>