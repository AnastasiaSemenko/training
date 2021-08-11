package com.epam.training.strings.service;

import com.epam.training.strings.domain.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher {
    public static String searchTheOftenMetWord(Text text) {
        List<String> sentences = new ArrayList<>();
        String oftenMetWord = "";
        int count = 0;

        for (String word : text.getArrayOfWords()) {
            List<String> tempArray = new ArrayList<>();
            int tempCount = 0;
            for (String sentence : text.getArrayOfSentences()) {
                Matcher matcher = Pattern.compile(".*\\b" + word + "\\b.*", Pattern.CASE_INSENSITIVE).matcher(sentence);
                if (matcher.find()) {
                    tempArray.add(sentence);
                    tempCount++;
                }
            }
            if (count < tempCount) {
                sentences = tempArray;
                oftenMetWord = word;
                count = tempCount;
            }
        }
        return getInfo(oftenMetWord, count, sentences);
    }

    private static String getInfo(String word, int count, List<String> sentences) {
        StringBuilder str = new StringBuilder();
        str.append("Слово |").append(word).append("| встречается в ").append(count).append(" предложениях текста:\n");
        for (String sentence : sentences) {
            str.append("-").append(sentence).append("\n");
        }
        return str.toString();
    }
}
