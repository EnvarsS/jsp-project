package org.envycorp.model.plot_Iterators;

import org.envycorp.model.Scene_Elements.Scene;
import org.envycorp.util.SceneLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class PlotIterator implements SceneIterator {

    private SceneLoader sceneLoader;

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
        this.sceneLoader = new SceneLoader();
        scenes = loadScenes();
        currentScene = Optional.of(scenes.get(index));
    }

    @Override
    public Optional<Scene> getCurrentScene() {
        return currentScene;
    }

    protected abstract String getScenesFilePath();

    @Override
    public ArrayList<Scene> loadScenes() {
        return sceneLoader.getAllScenes(getScenesFilePath());
    }
}
