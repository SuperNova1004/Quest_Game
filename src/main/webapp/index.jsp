<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Начало игры</title>
    <style>
        body {
            background-color: lightblue; /* Голубой фон */
            text-align: center; /* Центрирование текста */
        }
        .container {
            margin: auto; /* Автоматические отступы */
            width: 50%; /* Ширина контейнера */
            text-align: center; /* Центрирование текста внутри контейнера */
        }
        button {
            background-color: #d8bfd8; /* Светло-фиолетовый цвет */
            color: black; /* Чёрный цвет текста */
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
<div class="container">
    <h1>Добро пожаловать в текстовый квест!</h1>
    <form action="game" method="post">
        <label for="playerName">Введите ваше имя:</label><br>
        <input type="text" id="playerName" name="playerName" required><br><br>
        <button type="submit">Начать игру</button>
    </form>
</div>
</body>
</html>




