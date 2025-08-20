package org.envycorp.model.Scene_Elements;

import java.util.List;

public class Scene {
    private String index;
    private String text;
    private List<Choice> choices;

    public Scene(String index, String text, List<Choice> choices) {
        this.index = index;
        this.text = text;
        this.choices = choices;
    }

    public Scene() {
    }

    public String getIndex() {
        return index;
    }

    public String getText() {
        return text;
    }

    public List<Choice> getChoices() {
        return choices;
    }


}
