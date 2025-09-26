package org.envycorp.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.envycorp.model.Exceptions.SceneLoadingException;
import org.envycorp.model.Scene_Elements.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SceneLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(SceneLoader.class);
    private List<Scene> scenes;

    public SceneLoader() {

    }

    public Scene getFirstScene() {
        String firstSceneFile = "/first-scene.json";
        return loadScenes(firstSceneFile).getFirst();
    }

    public ArrayList<Scene> getAllScenes(String scenesFilePath){
        return loadScenes(scenesFilePath);
    }

    private ArrayList<Scene> loadScenes(String scenesFilePath){
        ArrayList<Scene> scenes;

        ObjectMapper mapper = new ObjectMapper();
        InputStream scenesFile = SceneLoader.class.getResourceAsStream(scenesFilePath);
        if (scenesFile == null) {
            LOGGER.error("Unable to load file: {}", scenesFilePath);
            throw new SceneLoadingException("Could not find " + scenesFilePath);
        }
        try {
            scenes = mapper.readValue(scenesFile, new TypeReference<ArrayList<Scene>>() {});
        } catch (IOException e) {
            LOGGER.error("Unable to load scenes from file");
            throw new SceneLoadingException(e);
        }

        return scenes;
    }
}
