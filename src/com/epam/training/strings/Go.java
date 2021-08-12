package com.epam.training.strings;

import com.epam.training.strings.domain.Text;
import com.epam.training.strings.service.FileIO;
import com.epam.training.strings.service.Searcher;

public class Go {
    public static void main(String[] args) {
        String content = FileIO.fileRead("Data/test.txt");
        Text text = new Text(content);
        System.out.println(text.getParser());
        System.out.println(Searcher.searchTheOftenMetWord(text));
    }
}
