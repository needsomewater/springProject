<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> ** 회원 가입 **</title>
</head>
<body>
<!-- p.144 참고 규약-->
<h3> 회원가입 </h3>
<form action="/party/createPartyByRedirect" method="post">

계정이름 : <input type="text" name="name"><br>

성별:
<div>
<input type="radio" name="sex" value="true" checked>
<label for="male">남자</label>
</div>
<div>
<input type="radio" name="sex" value="false">
<label for="female">여자</label>
</div> 
<br>

생년월일 <input type="date" name="birthDate">
<br>


<input type="hidden" name="listContactPoint[0].ContactPointType" value="addr"><br>
주소: <input type="text" name="listConatactPoint[0].value">

<input type="hidden" name="listContactPoint[1].ContactPointType" value="phoneNum"><br>
전화번호: <input type="text" name="listContactPoint[1].value">
<br>


내 나이 : <input type="text" name="ageOfMine">



<button type="submit">가입</button>

</form>

</body>

</html>