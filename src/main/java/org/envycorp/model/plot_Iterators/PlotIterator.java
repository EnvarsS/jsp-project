package org.envycorp.model.plot_Iterators;

import org.envycorp.model.Scene_Elements.Scene;

import java.util.List;
import java.util.Optional;

public abstract class PlotIterator implements SceneIterator {

    private Integer index = 0;
    private List<Scene> scenes;
    private Optional<Scene> currentScene;

    @Override
    public void nextScene() {
        if(!hasNext()) {
            currentScene = Optional.empty();
            return;
        }
        index++;
        currentScene = Optional.of(scenes.get(index));
    }

    @Override
    public boolean hasNext() {
        return (index + 1) < scenes.size();
    }

    public PlotIterator(){
        scenes = loadScenes();
        currentScene = Optional.of(scenes.get(index));
    }

    @Override
    public Optional<Scene> getCurrentScene() {
        return currentScene;
    }
}
