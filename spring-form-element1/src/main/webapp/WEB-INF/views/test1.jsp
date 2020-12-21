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
        modelAttribute : form 태그 내의 입력 요소들에 적용될 value 값을 가진 객체 이름
        이 속성의 값이 id 속성으로 설정된다.
        생략 시 id : command, action : 현재 페이지 설정, method : post
     --%>
    <%--@elvariable id="dataBean" type="kr.co.softcampus.beans.DataBean"--%>
    <form:form modelAttribute="dataBean" action="result" method="get">
        <%--
            form:hidden
            hidden 타입의 input 태그 생성
            path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.
        --%>
        <form:hidden path="a1"/>
        <%--
            form:input
            text 타입의 input 태그를 생성
            path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.
        --%>
        텍스트 : <form:input path="a2"/><br>
        <%--
            form:password
            password 타입의 input 태그를 생성
            path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.
            showPassword : 셋팅될 값의 이름을 지정하더라도 값이 셋팅되지 않는데 이 속성에 true를 넣어주면 값이 셋팅된다.
        --%>
        패스워드 : <form:password path="a3" showPassword="true"/><br>
        <%--
            form:textarea
            textarea 타입의 input 태그를 생성
            path : 설정한 문자열은 id와 name 속성으로 지정되며 model의 값을 추출해 value 속성에 주입한다.
        --%>
        textarea : <form:textarea path="a4"/><br>
       <%--
            form:button
            Submit 버튼을 생성
            disabled : true를 셋팅해주면 버튼을 누를 수 없도록 비활성화 된다.
        --%>
        <form:button>확인</form:button>
    </form:form>
</body>
</html>
