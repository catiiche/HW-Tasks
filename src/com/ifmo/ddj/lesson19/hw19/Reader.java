package com.ifmo.ddj.lesson19.hw19;

import java.io.*;

public class Reader {
    public static String readFromFile(File file) throws IOException {
        String res = null;
        try (FileInputStream in = new FileInputStream(file);
             DecryptionDecorator fileStream =
                     new DecryptionDecorator(in);
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ) {
            byte[] bytes = new byte[300];
            int data;

            while ((data = fileStream.read(bytes)) != -1) {
                byteArray.write(fileStream.decrypt(bytes), 0, data);
            }
            res = new String(byteArray.toByteArray());
        }
        return res;
    }
}

