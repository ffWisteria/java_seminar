<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import.jsp" %>

<%--<%@ page import="model.user.User" %>--%>
<%--<%--%>
<%--    //Servletのデータを受け取る--%>
<%--    request.setCharacterEncoding("UTF-8");--%>
<%--    User user = (User) request.getAttribute("user");--%>
<%--%>--%>

<%--JSTL を使うメリット--%>
<%--- jsp に java を書かなくてもよくなる。（HTML の専門家 でもなんとなく読めるようになる。）--%>
<%--- リクエストスコープの読み込みがいなくなる。--%>

<%--<% if (user != null){%>--%>
<%--    <%= user.name%>--%>
<%--<%}%>--%>
<%--  <c:if test="{条件式}">  --%>
<%--  <c:out value="${出力したい値・式}">  --%>
<c:if test="${user != null}">
    <c:out value ="${user.name}"/>
</c:if>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザー登録</title>
</head>
<body>
<h1>ユーザー登録</h1>
<form action = "/users/new" method="post">
    <label>名前:</label><br>
    <input type="text" name="name"><br>

    <label>メールアドレス:</label><br>
    <input type="email" name="email"><br>

    <label>パスワード</label><br>
    <input type="password" name="password"><br>

    <input type="submit" value="送信">
</form>
</body>
</html>