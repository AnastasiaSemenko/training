package com.epam.training.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text extends TextComponent {
    public static StringBuilder parser = new StringBuilder();
    private static final String REGEX_PUNCTUATION = "(\\p{Punct}\\s)";
    private static final String REGEX_WORD = "([\\w-]+)";
    private static final String REGEX_EMAIL = "([\\w\\.-]+@[a-z]+\\.[a-z]{2,})";
    private static final String REGEX_PHONE = "(\\+\\d{3}\\(\\d{2}\\)\\d{3}-\\d{2}-\\d{2})";
    private static final String REGEX_SENTENCE = "([^.!?]+(([.]\\S[^.!?]+)*[.!?][\\s]))";

    public Text(String text) {
        super(text.replaceAll("\\s+", " "));
    }

    @Override
    protected void contentParsing() {
        Text.parser.append("Текст: ").append(text).append("\nСостоит из: \n");
        Matcher matcher = Pattern.compile(REGEX_SENTENCE).matcher(text);
        while (matcher.find()) {
            Sentence sentence = new Sentence(matcher.group());
        }
    }

    public StringBuilder getParser() {
        return parser;
    }

    public static String getRegexPunctuation() {
        return REGEX_PUNCTUATION;
    }

    public static String getRegexWord() {
        return REGEX_WORD;
    }

    public static String getRegexEmail() {
        return REGEX_EMAIL;
    }

    public static String getRegexPhone() {
        return REGEX_PHONE;
    }

    public static String getRegexSentence() {
        return REGEX_SENTENCE;
    }

    private static class Sentence extends TextComponent {
        protected Sentence(String text) {
            super(text);
        }

        @Override
        protected void contentParsing() {
            Text.parser.append("Предложение - ").append(text).append("\nСостоит из следующих элементов:\n");
            Matcher matcher = Pattern.compile(REGEX_EMAIL + "|" + REGEX_PHONE + "|" + REGEX_WORD + "|" + REGEX_PUNCTUATION).matcher(text);
            while (matcher.find()) {
                if (matcher.group().matches(REGEX_PUNCTUATION)) {
                    Punctuation punctuation = new Punctuation(matcher.group());
                } else {
                    Word word = new Word(matcher.group());
                }
            }
        }

        private static class Word extends TextComponent{
            protected Word(String text) {
                super(text);
            }

            @Override
            protected void contentParsing() {
                Text.parser.append(text).append(" - слово\n");
            }
        }

        private static class Punctuation extends TextComponent{
            protected Punctuation(String text) {
                super(text);
            }

            @Override
            protected void contentParsing() {
                Text.parser.append(text).append(" - знак препинания\n");
            }
        }
    }
}



