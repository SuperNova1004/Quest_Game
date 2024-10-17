package com.game;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Player player = (Player) session.getAttribute("player");
        GameLogic gameLogic = (GameLogic) session.getAttribute("gameLogic");

        // Если сессия новая, создаем игрока и логику игры
        if (player == null) {

            String playerName = request.getParameter("name");
            player = new Player(playerName);
            session.setAttribute("player", player);
        }

        if (gameLogic == null) {

            gameLogic = new GameLogic(player);
            session.setAttribute("gameLogic", gameLogic);
        }

        // Отображение текущего вопроса
        request.setAttribute("question", gameLogic.getCurrentQuestion());
        request.setAttribute("playerName", player.getName());

        // Переход на страницу игры
        getServletContext().getRequestDispatcher("/game.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        GameLogic gameLogic = (GameLogic) session.getAttribute("gameLogic");
        Player player = (Player) session.getAttribute("player");

        // Обработка ответа игрока
        String answer = request.getParameter("answer");
        gameLogic.processAnswer(answer);

        // Если игра окончена, предложить начать заново
        if (gameLogic.isGameOver()) {

            player.incrementGamesPlayed();
            request.setAttribute("message", "Game Over! Want to play again?");
        }

        // Обновление вопроса или завершение игры
        request.setAttribute("question", gameLogic.getCurrentQuestion());
        request.setAttribute("playerName", player.getName());
        request.setAttribute("gamesPlayed", player.getGamesPlayed());

        getServletContext().getRequestDispatcher("/game.jsp").forward(request, response);
    }
}
