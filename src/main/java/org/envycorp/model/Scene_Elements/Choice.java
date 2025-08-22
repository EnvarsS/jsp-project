package org.envycorp.model.Scene_Elements;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Choice choice = (Choice) o;
        return positive == choice.positive && Objects.equals(text, choice.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, positive);
    }
}
