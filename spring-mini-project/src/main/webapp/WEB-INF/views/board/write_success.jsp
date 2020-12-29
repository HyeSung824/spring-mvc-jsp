<%--
  작성자: 김홍준
  작성일: 2020-12-29 오전 10:33
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    alert('저장되었습니다.');
    location.href = '${pageContext.request.contextPath}/board/read?board_info_idx=${writeContentBean.content_board_idx}&content_idx=${writeContentBean.content_idx}';
</script>
