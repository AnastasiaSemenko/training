package com.epam.training.strings.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileIO {
    public static String fileRead(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            System.err.println("Во время загрузки текста произошла ошибка!");
            return null;
        }
    }
}
