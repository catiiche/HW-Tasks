package com.ifmo.ddj.lesson7;

import com.ifmo.ddj.lesson20.serialization.serialization.Pupil;

import java.io.*;

public class ReadObject {
    public static void main(String[] args) {
        File file = new File("BattleUnit.bin");
        Infantry infantry1 = (Infantry) objectFromFile(file);
        System.out.println(infantry1);
        Infantry infantry2 = (Infantry) objectFromFile(file);
        System.out.println(infantry2);

    }

    private static Object objectFromFile(File file) {
        Object o = null;
        try (FileInputStream fileInput = new FileInputStream(file);
             ObjectInputStream inStream = new ObjectInputStream(fileInput)) {
            o = inStream.readObject();
        } catch (FileNotFoundException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }
}


