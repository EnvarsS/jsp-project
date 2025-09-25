package org.envycorp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.envycorp.service.StartService;
import org.envycorp.util.SceneLoader;

import java.io.IOException;

@WebServlet(name = "StartServlet", value = "/start")
public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession(true);
        session.setAttribute("currentScene", SceneLoader.getInstance().getFirstScene());
        session.setAttribute("userPoints", 0);

        req.getRequestDispatcher("/start.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StartService gameService = new StartService();
        gameService.startGame(req);

        resp.sendRedirect("/game");
    }
}
