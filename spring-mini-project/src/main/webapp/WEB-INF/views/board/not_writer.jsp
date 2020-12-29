<%--
  작성자: 김홍준
  작성일: 2020-12-29 오전 10:33
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    alert('잘못된 접근입니다');
    location.href = '${pageContext.request.contextPath}/main';
</script>
