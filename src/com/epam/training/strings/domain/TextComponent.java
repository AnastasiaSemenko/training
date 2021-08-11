package com.epam.training.strings.domain;

public abstract class TextComponent {
    protected final String text;

    protected TextComponent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    protected abstract void contentParsing();
}
