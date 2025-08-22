package org.envycorp.model.plot_Iterators;

import org.envycorp.model.Scene_Elements.Scene;
import org.envycorp.util.SceneLoader;

import java.util.ArrayList;

public class WalkingPlotIterator extends PlotIterator {
    private static final String scenesFilePath = "/walking-plot-scenes.json";
    @Override
    public ArrayList<Scene> loadScenes() {
        return SceneLoader.getInstance().getAllScenes(scenesFilePath);
    }
}
