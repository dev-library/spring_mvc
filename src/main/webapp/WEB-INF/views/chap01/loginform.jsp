<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>로그인 하기</h1>
    <form action="http://localhost:8080/chap01/login" method="POST">
        아이디 : <input type="text" name="id"><br/>
        비밀번호 : <input type="password" name="pw"><br/>
        <input type="submit" value="로그인하기">
    </form>
</body>
</html>