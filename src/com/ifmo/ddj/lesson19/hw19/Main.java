package com.ifmo.ddj.lesson19.hw19;


import java.io.*;

public class Main {
    public static void main(String[] args) {

        File file = new File("encryptfile.txt");

        try {
            Writer.writeToFile(file, "trusofhslaa", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Reader.readFromFile(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

