package org.envycorp.model.Scene_Elements;

import java.util.List;
import java.util.Objects;

public class Scene {
    private String index;
    private String text;
    private List<Choice> choices;

    public Scene() { }

    public Scene(String index, String text, List<Choice> choices) {
        this.index = index;
        this.text = text;
        this.choices = choices;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scene scene = (Scene) o;
        return index.equals(scene.index) &&
               text.equals(scene.text) &&
               choices.equals(scene.choices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, text, choices);
    }

}
