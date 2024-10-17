<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>

<head>

    <title>Текстовый квест</title>

</head>
<body>

<h1>Добро пожаловать в текстовый квест!</h1>
<p>Готовы начать свое приключение?</p>

<form action="game.jsp" method="post">
    <label for="playerName">Введите ваше имя:</label>
    <input type="text" id="playerName" name="playerName" required>
    <button type="submit">Начать игру</button>

</form>
</body>
</html>
