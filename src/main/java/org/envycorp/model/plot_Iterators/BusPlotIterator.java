package org.envycorp.model.plot_Iterators;

import org.envycorp.model.Scene_Elements.Scene;
import org.envycorp.util.SceneLoader;

import java.util.ArrayList;

public class BusPlotIterator extends PlotIterator {
    private final String scenesFilePath = "/bus-plot-scenes";
    @Override
    public ArrayList<Scene> getScenes() {
        return SceneLoader.getInstance().getAllPlotScenes(scenesFilePath);
    }
}
