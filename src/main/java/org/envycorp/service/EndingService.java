package org.envycorp.service;

import jakarta.servlet.http.HttpSession;
import org.envycorp.model.Scene_Elements.Scene;
import org.envycorp.util.EndingGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EndingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EndingService.class);

    public void generateEndingScene(HttpSession session, EndingGenerator endingGenerator) {
        LOGGER.info("Generating ending scene based on user points: {}", session.getAttribute("userPoints"));
        Scene endingScene = endingGenerator.getEndingScene((int) session.getAttribute("userPoints"));
        session.setAttribute("currentScene", endingScene);

    }


}
