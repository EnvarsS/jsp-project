package org.envycorp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.envycorp.model.plot_Iterators.BusPlotIterator;
import org.envycorp.model.plot_Iterators.SceneIterator;
import org.envycorp.model.plot_Iterators.WalkingPlotIterator;
import org.envycorp.util.SceneLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        HttpSession session = req.getSession(true);

        boolean isBusPlot = req.getParameter("isBusPlot").equals("true");

        SceneIterator plotIterator;

        if (isBusPlot) {
            plotIterator = new BusPlotIterator();
        } else {
            plotIterator = new WalkingPlotIterator();
        }

        session.setAttribute("optionalScene", plotIterator.getCurrentScene());
        session.setAttribute("plotIterator", plotIterator);

        resp.sendRedirect("/game");
    }
}
