package org.envycorp.model.Scene_Elements;

public class Choice {
    private String text;
    private boolean positive;

    public Choice(String text, boolean positive) {
        this.text = text;
        this.positive = positive;
    }

    public Choice() {
    }

    public String getText() {
        return text;
    }

    public boolean isPositive() {
        return positive;
    }

}
