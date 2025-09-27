package org.envycorp.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.envycorp.model.Ending_Iterators.EndingIterator;
import org.envycorp.model.Factory.UserEndingFactory;
import org.envycorp.model.plot_Iterators.BusPlotIterator;
import org.envycorp.model.plot_Iterators.SceneIterator;
import org.envycorp.model.plot_Iterators.WalkingPlotIterator;
import org.envycorp.util.EndingGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StartService.class);

    public void startGame(HttpSession session, boolean isBusPlot) {
        SceneIterator plotIterator;

        if (isBusPlot) {
            plotIterator = new BusPlotIterator();
        } else {
            plotIterator = new WalkingPlotIterator();
        }

        session.setAttribute("optionalScene", plotIterator.getCurrentScene());
        session.setAttribute("plotIterator", plotIterator);

        EndingIterator endingIterator = UserEndingFactory.createEndingIterator(plotIterator);
        EndingGenerator generator = new EndingGenerator(endingIterator);

        session.setAttribute("EndingGenerator", generator);

        LOGGER.info("Game started with {} plot.", isBusPlot ? "Bus" : "Walking");

    }
}
