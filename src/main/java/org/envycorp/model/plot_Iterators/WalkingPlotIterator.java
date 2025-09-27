package org.envycorp.model.plot_Iterators;

import org.envycorp.model.Ending_Iterators.EndingIterator;
import org.envycorp.model.Ending_Iterators.WalkingEndingIterator;

public class WalkingPlotIterator extends PlotIterator {
    private static final String SCENES_FILE_PATH = "/walking-plot-scenes.json";
    @Override
    protected String getScenesFilePath() {
        return SCENES_FILE_PATH;
    }

    @Override
    public EndingIterator createEndingIterator() {
        return new WalkingEndingIterator();
    }
}
