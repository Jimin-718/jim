<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
<h2>
MBC 아카데미 게시판
</h2>
</header>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">board</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">게시판 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="boardinput">게시판글올리기</a></li>
          <li><a href="boardout">게시판글출력</a></li>
          <li class="divider"></li>
           <li><a href="b2input">Q&A 질문하기</a></li>
          <li><a href="b2out">Q&A 출력</a></li>
          <li class="divider"></li>
           <li><a href="mapgo">지도</a></li>
        </ul>
      </li>    
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">개인정보 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">개인정보입력</a></li>
          <li><a href="#">개인정보출력</a></li>
          <li class="divider"></li>
           <li><a href="#">개인정보구입내역</a></li>
          
        </ul>
      </li>   
      
         <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">상품정보 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="sinput">상품정보입력</a></li>
          <li><a href="sout">상품정보출력</a></li>
          
        </ul>
      </li>                 
       
       <form class="navbar-form navbar-left" action="search" method="get">
      <div class="form-group">
        <input type="text" class="form-control" name="spname" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">검색</button>
    </form>
       
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:choose>
    	<c:when test="${loginstate==true }">
    		<li><a href="#"><span class="glyphicon glyphicon-user"></span>${id}님!!반갑습니다</a></li>
      		<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a></li>    	
    	</c:when>
    	<c:otherwise>
    		<li><a href="minput"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>
      		<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>로그인</a></li>
    	</c:otherwise>
    
    </c:choose>
      
    </ul>
  </div>
</nav>
  
</body>
</html>