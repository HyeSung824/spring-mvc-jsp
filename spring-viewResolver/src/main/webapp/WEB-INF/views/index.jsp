<%--
  작성자: 김홍준
  작성일: 2020-11-16 오후 11:27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/test1?data1=100&data2=200">test1</a>
    <hr/>
    <a href="${pageContext.request.contextPath}/test2">test2</a>
    <hr/>
    <a href="${pageContext.request.contextPath}/test3">test3</a>
    <hr/>
    <a href="${pageContext.request.contextPath}/test4">test4</a>

</body>
</html>
