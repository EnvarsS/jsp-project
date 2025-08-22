package org.envycorp.model.plot_Iterators;

import org.envycorp.model.Scene_Elements.Scene;

import java.util.ArrayList;
import java.util.Optional;

public interface SceneIterator {
    void nextScene();

    boolean hasNext();

    ArrayList<Scene> loadScenes();

    Optional<Scene> getCurrentScene();
}
