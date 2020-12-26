<%--
  작성자: 김홍준
  작성일: 2020-11-16 오후 11:27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>input_data</h1>
    <%--@elvariable id="dataBean1" type="kr.co.softcampus.beans.DataBean1"--%>
    <form:form modelAttribute="dataBean1" action="input_pro">
        data1 : <form:input path="data1"/> <br>
        <form:errors path="data1"/> <br>

        data2 : <form:input path="data2"/> <br>
        <form:errors path="data2"/> <br>

        data3 : <form:input path="data3"/> <br>
        <form:errors path="data3"/> <br>

        data4 : <form:input path="data4"/> <br>
        <form:errors path="data4"/> <br>

        data5 : <form:input path="data5"/> <br>
        <form:errors path="data5"/> <br>

        data6 : <form:input path="data6"/> <br>
        <form:errors path="data6"/> <br>

        data7 : <form:input path="data7"/> <br>
        <form:errors path="data7"/> <br>

        <form:button type="submit">확인</form:button>
    </form:form>
</body>
</html>
