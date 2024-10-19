<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Начало игры</title>
    <style>
        body {
            background-color: lightblue; /* Голубой фон */
        }
        button {
            background-color: #d8bfd8; /* Светло-фиолетовый цвет */
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            font-size: 16px;
            margin: 10px;
            cursor: pointer;
            border-radius: 5px;
        }
        button:hover {
            background-color: #c0a0c0; /* Более тёмный оттенок при наведении */
        }
        input[type="text"] {
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #d8bfd8;
        }
    </style>
</head>
<body>
<h1>Добро пожаловать в текстовый квест!</h1>
<form action="game" method="post">
    <label for="playerName">Введите ваше имя:</label><br>
    <input type="text" id="playerName" name="playerName" required><br><br>
    <button type="submit">Начать игру</button>
</form>
</body>
</html>



