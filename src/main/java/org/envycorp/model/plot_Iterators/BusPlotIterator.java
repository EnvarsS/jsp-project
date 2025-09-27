package org.envycorp.model.plot_Iterators;

import org.envycorp.model.Ending_Iterators.BusEndingIterator;
import org.envycorp.model.Ending_Iterators.EndingIterator;

public class BusPlotIterator extends PlotIterator {
    private static final String SCENES_FILE_PATH = "/bus-plot-scenes.json";

    @Override
    protected String getScenesFilePath() {
        return SCENES_FILE_PATH;
    }

    @Override
    public EndingIterator createEndingIterator() {
        return new BusEndingIterator();
    }
}
