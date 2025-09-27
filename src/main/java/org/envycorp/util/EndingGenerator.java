package org.envycorp.util;

import org.envycorp.model.Ending_Iterators.EndingIterator;
import org.envycorp.model.Scene_Elements.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndingGenerator {
    private final int GOOD_ENDING_POINTS = 4;

    private final EndingIterator endingIterator;

    public EndingGenerator(EndingIterator endingIterator) {
        this.endingIterator = endingIterator;
    }

    public Scene getEndingScene(int userPoints){
        return userPoints >= GOOD_ENDING_POINTS ? endingIterator.getGoodEnding() : endingIterator.getBadEnding();
    }
}
