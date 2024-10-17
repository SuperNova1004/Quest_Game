package com.game;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LogicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GameLogic gameLogic = (GameLogic) session.getAttribute("gameLogic");

        if (gameLogic == null) {
            String playerName = (String) session.getAttribute("playerName");
            Player player = new Player(playerName);
            gameLogic = new GameLogic(player);
            session.setAttribute("gameLogic", gameLogic);
        }

        String answer = request.getParameter("answer");
        if (answer != null) {
            gameLogic.processAnswer(answer);
        }

        // Если игра закончена, обработать рестарт
        String action = request.getParameter("action");
        if ("restart".equals(action)) {
            gameLogic.resetGame();
        }

        request.setAttribute("question", gameLogic.getCurrentQuestion());
        request.setAttribute("step", gameLogic.getCurrentStep());
        request.setAttribute("gameResult", gameLogic.getGameResult());

        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }
}
