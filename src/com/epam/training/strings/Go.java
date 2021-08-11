package com.epam.training.strings;

public class Go {
    public static void main(String[] args) {
        Text text = FileIO.fileRead("Data/test.txt");
        //Text text = new Text("Первое предложение. Второе предложение! Третье предложение?");
        System.out.println(text.getParser());
    }
}
