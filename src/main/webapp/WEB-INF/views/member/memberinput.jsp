<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#idcheck").click(function() {
		var id=$("#id").val();
		
		$.ajax({
			type:"post",
		    url:"idcheck",
		    data:{"id":id},
		    async:true,
		    success:function(data){
		    	if(data=="ok"){
		    		alert("사용가능 ID");
		    	}
		    	else{
		    		alert("사용중인 ID");
		    	}
		    }
		});
	});
});

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="membersave">
<table border="1" width="400px" align="center">
<caption>회원가입</caption>
<tr>
<th>아이디</th>
<td><input type="text" name="id"></td>
</tr>
<tr>
<th>비밀번호</th>
<td><input type="text" name="pw"></td>
</tr>
<tr>
<th>이름</th>
<td><input type="text" name="name"></td>
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