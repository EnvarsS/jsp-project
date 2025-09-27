package org.envycorp.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.envycorp.model.plot_Iterators.SceneIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameService.class);

    public void calculateScore(HttpSession session, boolean isPositiveAnswer) {
        if (isPositiveAnswer) {
            int userPoints = (int) session.getAttribute("userPoints");
            userPoints++;
            session.setAttribute("userPoints", userPoints);
            LOGGER.info("User answered positively. Points increased to {}.", userPoints);
        }
    }

    public void delegateNextScene(HttpSession session) {
        SceneIterator plotIterator = (SceneIterator) session.getAttribute("plotIterator");
        plotIterator.nextScene();
        session.setAttribute("plotIterator", plotIterator);
        LOGGER.info("Moved to next scene.");
    }
}
