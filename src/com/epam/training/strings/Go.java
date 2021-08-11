package com.epam.training.strings;

import com.epam.training.strings.domain.Text;
import com.epam.training.strings.service.FileIO;
import com.epam.training.strings.service.Searcher;

public class Go {
    public static void main(String[] args) {
        Text text = FileIO.fileRead("Data/test.txt");
        System.out.println(text.getParser());
        System.out.println(Searcher.searchTheOftenMetWord(text));
    }
}
