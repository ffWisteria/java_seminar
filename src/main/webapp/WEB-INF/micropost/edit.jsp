<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>つぶやき編集</title>
</head>
<body>
<h1>つぶやき編集</h1>
<form action="/microposts/edit" method="post">
    <label>内容</label>
    <input type="text" name="content"><br>
    <input type="hidden" name="id" value="${id}">
    <input type="submit" value="送信">
</form>
</body>
</html>