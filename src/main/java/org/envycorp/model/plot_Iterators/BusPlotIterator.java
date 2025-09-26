package org.envycorp.model.plot_Iterators;

import org.envycorp.model.Ending_Iterators.BusEndingIterator;
import org.envycorp.model.Ending_Iterators.EndingIterator;
import org.envycorp.model.Scene_Elements.Scene;
import org.envycorp.util.SceneLoader;

import java.util.ArrayList;

public class BusPlotIterator extends PlotIterator {
    private static final String scenesFilePath = "/bus-plot-scenes.json";

    @Override
    protected String getScenesFilePath() {
        return scenesFilePath;
    }

    @Override
    public EndingIterator createEndingIterator() {
        return new BusEndingIterator();
    }
}
