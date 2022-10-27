<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<!-- 테스트할 때는 이 주소로 https://testapi.openbanking.or.kr - 이 주소는 작업에 동일함
	 인증은 /oauth/2.0/authorize 이 주소다 홈페이지에서 확인가능 -->

<!-- 인증 요청 작업 수행 -->
<form action="https://testapi.openbanking.or.kr/oauth/2.0/authorize" method="get">
	<input type="hidden" name="response_type" value="code" >
	<input type="hidden" name="client_id" value="6f948a13-11af-4892-b746-ee67d358abf2" >
	<input type="hidden" name="redirect_uri" value="http://localhost:8088/fintech/callback" >
	<input type="hidden" name="scope" value="login inquiry transfer" >
	<input type="hidden" name="state" value="12345678123456781234567812345678" >
	<input type="hidden" name="auth_type" value="0" >
	
	<input type="submit" value="토큰발급">

</form>




</body>
</html>
