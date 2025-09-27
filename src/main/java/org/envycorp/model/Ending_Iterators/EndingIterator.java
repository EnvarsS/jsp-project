package org.envycorp.model.Ending_Iterators;

import org.envycorp.model.Scene_Elements.Scene;
import org.envycorp.util.SceneLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public abstract class EndingIterator {
    private static final Logger LOGGER = LoggerFactory.getLogger(EndingIterator.class);

    private final ArrayList<Scene> scenes;
    private final SceneLoader sceneLoader;

    private static final int GOOD_ENDING_INDEX = 0;
    private static final int BAD_ENDING_INDEX = 1;

    public EndingIterator(String filePath){
        this.sceneLoader = new SceneLoader();
        scenes = sceneLoader.getAllScenes(filePath);
    }

    public Scene getGoodEnding(){
        LOGGER.info("Getting good ending iterator");
        return scenes.get(GOOD_ENDING_INDEX);
    }

    public Scene getBadEnding(){
        LOGGER.info("Getting bad ending iterator");
        return scenes.get(BAD_ENDING_INDEX);
    }


}
