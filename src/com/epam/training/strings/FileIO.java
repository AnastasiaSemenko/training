package com.epam.training.strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileIO {
    public static Text fileRead(String path) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get(path)));
            return new Text(contents);
        } catch (IOException e) {
            System.out.println("Во время загрузки текста произошла ошибка!");
            return null;
        }
    }
}
