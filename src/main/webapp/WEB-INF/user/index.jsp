<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザー一覧</title>
</head>
<body>
    <h1>ユーザー一覧</h1>
    <c:forEach var="user" items="${users}">
        名前：<c:out value="${user.name}"/><br>
        作成日：${Format.formatTimestamp(user.getCreatedAt(), "yyyy年MM月dd日")} <br>
    </c:forEach>
</body>
</html>
