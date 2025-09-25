package org.envycorp.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.envycorp.model.plot_Iterators.SceneIterator;

public class GameService {
    public void calculateScore(HttpServletRequest req) {
        HttpSession session = req.getSession();
        boolean isPositiveAnswer = req.getParameter("choice").equalsIgnoreCase("true");
        if (isPositiveAnswer) {
            int userPoints = (int) session.getAttribute("userPoints");
            userPoints++;
            session.setAttribute("userPoints", userPoints);
        }
    }
    public void delegateNextScene(HttpServletRequest req) {
        HttpSession session = req.getSession();
        SceneIterator plotIterator = (SceneIterator) session.getAttribute("plotIterator");
        plotIterator.nextScene();
        session.setAttribute("plotIterator", plotIterator);
    }
}
