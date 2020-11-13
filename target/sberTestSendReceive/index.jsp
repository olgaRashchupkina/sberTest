<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
</head>
<body>
<form action="servlet" method="POST">
<p>Отправьте сообщения с числом
    <input name="element" type="text" size="5"></p>
<p>значением
    <input name="value" type="text" size="5"></p>
<input type="submit" width="80" value="Отправить"><p />
<span id="sendJMS" style="color: #3f48cc;"> </span>

<p>Получите сообщения из очереди JBoss</p>
<input type="submit" width="80" value="Получить"
       onClick="receiveMessages()"><p />
<span id="receiveJMS" style="color: #7349a4;"> </span>
</form>
</body>
</html>