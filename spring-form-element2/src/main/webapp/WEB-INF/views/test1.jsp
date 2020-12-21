<%--
  작성자: 김홍준
  작성일: 2020-12-20 오후 8:26
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
    <h1>test1</h1>
    <%--
        form: select
        path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해
        값과 동일한 value 속성의 option 태그를 선택
     --%>
    <%--@elvariable id="dataBean" type="kr.co.softcampus.beans.DataBean"--%>
    <form:form modelAttribute="dataBean" action="result">
        <%--
            form:option
            select 태그의 option 태그 하나를 생성

            form:options
            select 태그의 option들을 생성

            items : option 태그들을 생성할 때 필요한 데이터가 담긴 list나 배열
        --%>
        <%--
            form:radioButton, form:radiobuttons
            form:radioButton : radiobutton 하나를 생성합니다.
            form:radioButton2 : radiobutton 들을 생성합니다.
            items : radiobutton들을 생성하기 위해 필요한 정보가 담겨있는 list나 배열
        --%>
        <form:select path="a1">
            <form:option value="data1">항목1</form:option>
            <form:option value="data2">항목2</form:option>
            <form:option value="data3">항목3</form:option>
        </form:select>
        <hr>
        <form:select path="a2">
            <form:options items="${requestScope.data_list1}"/>
        </form:select>
        <hr>
        <form:select path="a3">
            <form:options items="${requestScope.data_list2}"/>
        </form:select>

        <hr>
        <form:select path="a4">
            <form:options items="${requestScope.data_list3}" itemLabel="key" itemValue="value"/>
        </form:select>

        <hr>
        <form:checkbox path="a5" value="data1"/>항목1
        <form:checkbox path="a5" value="data2"/>항목2
        <form:checkbox path="a5" value="data3"/>항목3

        <hr>
        <form:checkboxes path="a6" items="${requestScope.data_list1}"/>

        <hr>
        <form:checkboxes path="a7" items="${requestScope.data_list2}"/>

        <hr>
        <form:checkboxes path="a8" items="${requestScope.data_list3}" itemLabel="key" itemValue="value"/>

        <hr>
        <form:radiobutton path="a9" value="data1"/>항목1
        <form:radiobutton path="a9" value="data2"/>항목2
        <form:radiobutton path="a9" value="data3"/>항목3

        <hr>
        <form:radiobuttons path="a10" items="${requestScope.data_list1}"/>

        <hr>
        <form:radiobuttons path="a11" items="${requestScope.data_list2}"/>

        <hr>
        <form:radiobuttons path="a12" items="${requestScope.data_list3}" itemLabel="key" itemValue="value"/>
    </form:form>
</body>
</html>
