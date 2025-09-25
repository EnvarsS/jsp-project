package org.envycorp.model.Factory;

import org.envycorp.model.Ending_Iterators.BusEndingIterator;
import org.envycorp.model.Ending_Iterators.EndingIterator;
import org.envycorp.model.Ending_Iterators.WalkingEndingIterator;
import org.envycorp.model.plot_Iterators.BusPlotIterator;
import org.envycorp.model.plot_Iterators.SceneIterator;
import org.envycorp.model.plot_Iterators.WalkingPlotIterator;

public class UserEndingFactory {
    public static EndingIterator createEndingIterator(SceneIterator sceneIterator) {
        return sceneIterator.createEndingIterator();
    }
}
