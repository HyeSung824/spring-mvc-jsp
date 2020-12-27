<%--
  작성자: 김홍준
  작성일: 2020-12-27 오후 10:50
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    alert('삭제되었습니다.');
    location.href = '${pageContext.request.contextPath}/board/main';
</script>
