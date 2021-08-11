package com.epam.training.strings;

public abstract class TextComponent {
    protected final String text;

    protected TextComponent(String text) {
        this.text = text;
        this.contentParsing();
    }

    public String getText() {
        return text;
    }

    protected abstract void contentParsing();
}
