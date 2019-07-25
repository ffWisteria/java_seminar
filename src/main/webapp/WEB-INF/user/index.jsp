<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザー一覧</title>
</head>
<body>
    <a href="/sessions/delete">ログアウト</a>
    <h1>ユーザー一覧</h1>
    ようこそ ! <c:out value="${currentUser.getName()}"/> さん<br>

    <c:forEach var="user" items="${users}">
        名前：<c:out value="${user.getName()}"/><br>
        作成日：${Format.formatTimestamp(user.getCreatedAt(), "yyyy年MM月dd日")} <br>
    </c:forEach>

</body>
</html>
