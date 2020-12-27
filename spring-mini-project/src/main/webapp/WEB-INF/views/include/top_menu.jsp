<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  작성자: 김홍준
  작성일: 2020-12-27 오후 9:22
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 상단 메뉴 부분 -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top shadow-lg">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/main">SoftCampus</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navMenu">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navMenu">
        <ul class="navbar-nav">
            <c:forEach var="obj" items="${topMenuList}">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/board/main?board_info_idx=${obj.board_info_idx}" class="nav-link">${obj.board_info_name}</a>
                </li>
            </c:forEach>
        </ul>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/user/login" class="nav-link">로그인</a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/user/join" class="nav-link">회원가입</a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/user/modify" class="nav-link">정보수정</a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/user/logout" class="nav-link">로그아웃</a>
            </li>
        </ul>
    </div>
</nav>
