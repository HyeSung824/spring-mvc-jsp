<%--
  작성자: 김홍준
  작성일: 2020-12-20 오후 8:26
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>test4</h1>
    <%--  requestScope 생략 가능  --%>
    <h3>data1: ${requestScope.data1}</h3>
    <h3>data2: ${requestScope.data2}</h3>
</body>
</html>
