package com.itmo.shkuratova.coursework3;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * class GameSaver implements Strategy
 * use for saving game
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see Strategy
 * @see SaveGame
 */
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
        File dir = new File(path);
        File[] arrFiles = dir.listFiles();
        List<File> lst = Arrays.asList(arrFiles);

        System.out.println("If you want load game  - copy string with file name where your game was saved from LIST");
        for (File file : lst) {
            System.out.println(file.getName());
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String fileName = reader.readLine();

                for (File file : lst) {
                    if (fileName.equalsIgnoreCase(file.getName())) {
                        String saveState = getStateFromFIle(file);
                        return saveState;
                    }
                }
                System.out.println("Wrong file name. Try again!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveGame(SaveGame game) {
        String fileName = "Fox " + game.getDateTime() + ".save";
        File file = new File(path, fileName);

        String saveSate = game.getGameState();
        if (saveSate == null) {
            saveSate = Nodes.START;
        }
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(saveSate);
            System.out.println("Game saved: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStateFromFIle(File file) {
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


