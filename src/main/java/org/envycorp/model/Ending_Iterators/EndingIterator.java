package org.envycorp.model.Ending_Iterators;

import org.envycorp.model.Scene_Elements.Scene;
import org.envycorp.util.SceneLoader;

import java.util.ArrayList;

public abstract class EndingIterator {
    private ArrayList<Scene> scenes;
    private final SceneLoader sceneLoader;

    public EndingIterator(String filePath){
        this.sceneLoader = new SceneLoader();
        scenes = sceneLoader.getAllScenes(filePath);
    }

    public Scene getGoodEnding(){
        return scenes.getFirst();
    }

    public Scene getBadEnding(){
        return scenes.get(1);
    }


}
