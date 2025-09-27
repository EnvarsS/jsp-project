package org.envycorp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.envycorp.model.Scene_Elements.Scene;
import org.envycorp.model.plot_Iterators.SceneIterator;
import org.envycorp.service.GameService;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    private static final String GAME_PAGE = "/game.jsp";
    private static final String GAME_URL = "/game";
    private static final String ENDING_URL = "/ending";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Optional<Scene> nextScene = ((SceneIterator) session.getAttribute("plotIterator")).getCurrentScene();

        if (nextScene.isEmpty()) {
            resp.sendRedirect(ENDING_URL);
            return;
        }
        else {
            Scene currentScene = nextScene.get();
            session.setAttribute("currentScene", currentScene);
        }

        req.getRequestDispatcher(GAME_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        GameService gameService = new GameService();

        HttpSession session = req.getSession();
        boolean isPositiveAnswer = req.getParameter("choice").equalsIgnoreCase("true");

        gameService.calculateScore(session, isPositiveAnswer);
        gameService.delegateNextScene(session);

        resp.sendRedirect(GAME_URL);
    }
}
