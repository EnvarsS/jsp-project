package org.envycorp.model.Factory;

import org.envycorp.model.Ending_Iterators.EndingIterator;
import org.envycorp.model.plot_Iterators.SceneIterator;

public class UserEndingFactory {
    public static EndingIterator createEndingIterator(SceneIterator sceneIterator) {
        return sceneIterator.createEndingIterator();
    }
}
