<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sample</title>
</head>
<body>

<a href="/microposts/new">つぶやき登録</a>
<h1>つぶやき一覧</h1>
<div>
    <h2>自分のつぶやき一覧</h2>
    <c:forEach var="myMicropost" items="${myMicroposts}">
        内容：<c:out value="${myMicropost.getContent()}"/><br>
        作成日：${Format.formatTimestamp(myMicropost.getCreatedAt(), "yyyy年MM月dd日")} <br>
        <a href="/microposts/edit?id=${myMicropost.getId()}">編集</a>
        <a href="/microposts/delete?id=${myMicropost.getId()}">削除</a> <br>
    </c:forEach>
</div>
<hr>
<div>
    <h2>他者のつぶやき一覧</h2>
    <c:forEach var="othersMicropost" items="${othersMicroposts}">
        内容：<c:out value="${othersMicropost.getContent()}"/><br>
        作成日：${Format.formatTimestamp(othersMicropost.getCreatedAt(), "yyyy年MM月dd日")} <br>
    </c:forEach>
</div>
</body>
</html>