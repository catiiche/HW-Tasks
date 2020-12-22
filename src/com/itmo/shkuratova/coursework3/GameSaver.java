package com.itmo.shkuratova.coursework3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameSaver implements Strategy {
    private final String path = "source/game";

    private SaveGame loadGame(File file) {
        try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(file))) {
            return (SaveGame) inStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getSaveState() {
        File dir = new File(path); //path указывает на директорию
        File[] arrFiles = dir.listFiles();
        List<File> lst = Arrays.asList(arrFiles);


        System.out.println("Type name of your file with saved game  from LIST  to reload game");
        for (File file : lst) {
            System.out.println(file.getName());
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String saveState = reader.readLine();

                for (File file : lst) {
                    if (saveState.equalsIgnoreCase(file.getName()))
                        return saveState;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveGame(SaveGame game) {
        File file = new File(path);

        System.out.println(game.getGameState());

        try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outStream.writeObject(game);
            System.out.println("Game saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
