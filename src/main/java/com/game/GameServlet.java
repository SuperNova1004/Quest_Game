package com.game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        GameLogic gameLogic = (GameLogic) session.getAttribute("gameLogic");

        // Если была нажата кнопка "Начать заново", сбросить игру
        if (request.getParameter("reset") != null) {
            Player player = gameLogic.getPlayer();
            gameLogic = new GameLogic(player); // Создаем новую игру для того же игрока
            session.setAttribute("gameLogic", gameLogic); // Обновляем атрибут с новой игрой
        }

        // Если игра еще не была создана
        if (gameLogic == null) {
            String playerName = request.getParameter("playerName");
            Player player = new Player(playerName);
            gameLogic = new GameLogic(player);
            session.setAttribute("gameLogic", gameLogic);
        }

        // Обрабатываем ответ на вопрос
        String answer = request.getParameter("answer");
        if (answer != null) {
            System.out.println("Answer received: " + answer);
            gameLogic.processAnswer(answer);
        }

        // Передаем текущий вопрос и статус игры в JSP
        request.setAttribute("question", gameLogic.getCurrentQuestion());
        request.setAttribute("isGameOver", gameLogic.isGameOver());
        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

}