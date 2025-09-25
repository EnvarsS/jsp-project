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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Optional<Scene> nextScene = ((SceneIterator) session.getAttribute("plotIterator")).getCurrentScene();

        if (nextScene.isEmpty()) {
            resp.sendRedirect("/ending");
            return;
        }
        else {
            Scene currentScene = nextScene.get();
            session.setAttribute("currentScene", currentScene);
        }

        req.getRequestDispatcher("/game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GameService gameService = new GameService();

        gameService.calculateScore(req);
        gameService.delegateNextScene(req);

        resp.sendRedirect("/game");
    }
}
