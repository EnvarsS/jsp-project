package org.envycorp.model.plot_Iterators;

import org.envycorp.model.Scene_Elements.Scene;
import org.envycorp.util.SceneLoader;

import java.util.ArrayList;

public class BusPlotIterator extends PlotIterator {
    private static final String scenesFilePath = "/bus-plot-scenes.json";
    @Override
    public ArrayList<Scene> loadScenes() {
        return SceneLoader.getInstance().getAllScenes(scenesFilePath);
    }
}
