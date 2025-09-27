package org.envycorp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.envycorp.service.StartService;
import org.envycorp.util.SceneLoader;

import java.io.IOException;

@WebServlet(name = "StartServlet", value = "/start")
public class StartServlet extends HttpServlet {
    private static final String START_PAGE = "/start.jsp";
    private static final String GAME_URL = "/game";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession(true);
        session.setAttribute("currentScene", new SceneLoader().getFirstScene());
        session.setAttribute("userPoints", 0);

        req.getRequestDispatcher(START_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StartService gameService = new StartService();

        HttpSession session = req.getSession(true);
        boolean isBusPlot = req.getParameter("isBusPlot").equalsIgnoreCase("true");

        gameService.startGame(session, isBusPlot);

        resp.sendRedirect(GAME_URL);
    }
}
