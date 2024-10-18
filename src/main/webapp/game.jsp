<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Text Adventure Game</title>
</head>
<body>
<h1>${question}</h1>
<c:if test="${isGameOver}">
    <p>Игра завершена!</p>
    <form action="game" method="post">
        <input type="hidden" name="reset" value="true"/>
        <button type="submit">Начать заново</button>
    </form>
</c:if>
    <form action="game" method="post">
        <c:choose>
            <c:when test="${question == 'У тёщи сегодня день рождения! Пойдёшь покупать подарки?'}">
                <button type="submit" name="answer" value="да">Да</button>
                <button type="submit" name="answer" value="нет">Нет</button>
            </c:when>
            <c:when test="${question == 'Пойдёшь выбирать вместе с женой?'}">
                <button type="submit" name="answer" value="Пойти вместе">Пойти вместе</button>
                <button type="submit" name="answer" value="Отказаться идти вдвоём">Отказаться идти вдвоём</button>
            </c:when>
            <c:when test="${question == 'Вы пришли в магазин. Предложить выбрать подарок подешевле?'}">
                <button type="submit" name="answer" value="Нет! Это твоя мама и она заслуживает самого лучшего">Нет! Это твоя мама и она заслуживает самого лучшего</button>
                <button type="submit" name="answer" value="Да! Нам нужно экономить">Да! Нам нужно экономить</button>
            </c:when>
        </c:choose>
    </form>
</body>
</html>


