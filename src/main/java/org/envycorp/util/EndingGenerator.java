package org.envycorp.util;

import org.envycorp.model.Ending_Iterators.EndingIterator;
import org.envycorp.model.Scene_Elements.Scene;

public class EndingGenerator {
    private final EndingIterator endingIterator;

    public EndingGenerator(EndingIterator endingIterator) {
        this.endingIterator = endingIterator;
    }

    public Scene getEndingScene(int userPoints){
        return userPoints >= 4 ? endingIterator.getGoodEnding() : endingIterator.getBadEnding();
    }
}
