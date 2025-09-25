package org.envycorp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.envycorp.model.Scene_Elements.Scene;
import org.envycorp.util.EndingGenerator;

import java.io.IOException;
@WebServlet(name = "EndingServlet", value = "/ending")
public class EndingServlet extends HttpServlet {
    private static final String ENDING_PAGE = "/ending.jsp";
    private static final String INDEX_PAGE = "/index.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        EndingGenerator generator = (EndingGenerator) session.getAttribute("EndingGenerator");
        Scene endingScene = generator.getEndingScene((int) session.getAttribute("userPoints"));
        session.setAttribute("currentScene", endingScene);

        req.getRequestDispatcher(ENDING_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(INDEX_PAGE);
    }
}
