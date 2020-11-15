package com.ifmo.ddj.lesson19.hw19;

import java.io.*;

public class Writer {
    public static void writeToFile(File file, String data, boolean append) throws IOException {
        try {
            file.createNewFile(); // создание файла , возвращает true/false
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (EncryptionDecorator someIODecorator =
                     new EncryptionDecorator(new BufferedOutputStream(new FileOutputStream(file, true)))) {
            byte[] bytes = data.getBytes(); // преобразование строки в массив байт
            someIODecorator.write(bytes); // запись массива байт
        }
    }
}


