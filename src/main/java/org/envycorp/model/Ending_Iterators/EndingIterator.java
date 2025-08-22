package org.envycorp.model.Ending_Iterators;

import org.envycorp.model.Scene_Elements.Scene;
import org.envycorp.util.SceneLoader;

import java.util.ArrayList;

public abstract class EndingIterator {
    private ArrayList<Scene> scenes;

    public EndingIterator(String filePath){
        scenes = SceneLoader.getInstance().getAllScenes(filePath);
    }

    public Scene getGoodEnding(){
        return scenes.getFirst();
    }

    public Scene getBadEnding(){
        return scenes.get(1);
    }


}
