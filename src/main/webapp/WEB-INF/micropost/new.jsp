<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>つぶやき登録</title>
</head>
<body>
    <h1>つぶやき登録</h1>
    <form action="/microposts/new" method="post">
        <label>内容</label>
        <input type="text" name="content"><br>

        <input type="submit" value="送信">
    </form>
</body>
</html>