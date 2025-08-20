package org.envycorp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.envycorp.util.SceneLoader;

import java.io.IOException;

@WebServlet(name = "StartServlet", value = "/start")
public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("currentScene", SceneLoader.getInstance().getFirstScene());
        session.setAttribute("userPoints", 0);

        resp.sendRedirect("/game.jsp");
    }
}
