<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="http://localhost:8181/chap03/foodorder" method="POST">
        고객명:<input type="text" name="customerName"><br/>
        테이블번호:<input type="number" name="tableNumber"><br/>
        주문메뉴명:<input type="text" name="orderFoodName"><br/>
        <input type="submit" value="제출">
    </form>
</body>
</html>