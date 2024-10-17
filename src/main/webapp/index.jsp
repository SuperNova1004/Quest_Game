<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Text Adventure Game</title>
</head>
<body>
<h1>Добро пожаловать в текстовый квест!</h1>
<form action="game" method="post">
    <label for="playerName">Введите ваше имя:</label>
    <input type="text" id="playerName" name="playerName" required>
    <button type="submit">Начать игру</button>
</form>
</body>
</html>


