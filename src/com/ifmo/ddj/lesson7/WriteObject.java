package com.ifmo.ddj.lesson7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
        Infantry infantry1 = new Infantry(12, 4, 5);
        Infantry infantry2 = new Infantry(10, 45, 54);

        try {
            try (FileOutputStream file = new FileOutputStream("BattleUnit.bin");
                 ObjectOutputStream outStream = new ObjectOutputStream(file)) {

                outStream.writeObject(infantry1);
                outStream.writeObject(infantry2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
