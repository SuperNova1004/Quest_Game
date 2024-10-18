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

        HttpSession session = request.getSession();
        GameLogic gameLogic = (GameLogic) session.getAttribute("gameLogic");

        // Сброс игры при нажатии кнопки "Начать заново"
        String reset = request.getParameter("reset");
        if (reset != null) {
            Player player = (Player) session.getAttribute("player");
            gameLogic = new GameLogic(player);
            session.setAttribute("gameLogic", gameLogic);
        }

        if (gameLogic == null) {
            String playerName = request.getParameter("playerName");
            Player player = new Player(playerName);
            gameLogic = new GameLogic(player);
            session.setAttribute("gameLogic", gameLogic);
        }

        // Обработка ответа
        String answer = request.getParameter("answer");
        if (answer != null) {
            gameLogic.processAnswer(answer);
        }

        // Передача параметров на JSP
        request.setAttribute("question", gameLogic.getCurrentQuestion());
        request.setAttribute("isGameOver", gameLogic.isGameOver());
        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }
}