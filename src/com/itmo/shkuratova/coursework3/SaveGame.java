package com.itmo.shkuratova.coursework3;

import java.io.*;

public class SaveGame {
    public void saveGame(Receiver receiver) {
        try {
            System.out.println("Для сохранения игры введите имя файла");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            File fileName = new File(reader.readLine());
            try (FileOutputStream stream = new FileOutputStream(fileName);
                 ObjectOutputStream objectOutput = new ObjectOutputStream(stream)) {
                objectOutput.writeObject(receiver);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
