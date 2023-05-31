<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <h1>${score.studentNumber}번 학생 성적정보</h1>

        <table class="table table-hover">
                <tr>
                    <td>이름</td>
                    <td>${score.name}</td>
                </tr>
                <tr>
                    <td>국어</td>
                    <td>${score.korScore}점</td>
                </tr>
                <tr>
                    <td>수학</td>
                    <td>${score.mathScore}점</td>
                </tr>
                <tr>
                    <td>영어</td>
                    <td>${score.engScore}점</td>
                </tr>
                <tr>
                    <td>총점</td>
                    <td>${score.korScore + score.mathScore + score.engScore}점</td>
                </tr>
                <tr>
                    <td>평균</td>
                    <td>${(score.korScore + score.mathScore + score.engScore) / 3}점</td>
                </tr>
        </table>
        <a href="/score/list" class="btn btn-primary">리스트로 돌아가기</a>
        <form action="/score/remove" method="POST">
            <input type="hidden" name="studentNumber" value="${score.studentNumber}">
            <input type="submit" class="btn btn-secondary" value="삭제하기">
        </form>
    </div>
</body>
</html>