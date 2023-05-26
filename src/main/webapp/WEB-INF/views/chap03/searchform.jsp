<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>submit 방식</h1>
    <form action="https://search.naver.com/search.naver" mehtod="GET">
        네이버 검색어 입력 : <input type="text" name="query">
        <input type="submit" value="검색하기">
    </form>
    <h1>리다이렉트 방식</h1>
    <form action="http://localhost:8181/chap03/research" mehtod="GET">
        네이버 검색어 입력 : <input type="text" name="query">
        <input type="submit" value="검색하기">
    </form>
</body>
</html>