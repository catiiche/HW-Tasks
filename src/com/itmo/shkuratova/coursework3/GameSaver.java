package com.itmo.shkuratova.coursework3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameSaver implements Strategy {
    private final String path;
    private static final String EXTENSION = ".sav";

    public GameSaver(String path) {
        this.path = "source/gameSaver/";
    }

    private SaveGame loadGame(File file) {
        try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(file))) {
            return (SaveGame) inStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SaveGame> getSaveList(String user) {
        try {
            return Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().endsWith(EXTENSION))
                    .map(Path::toFile)
                    .map(this::loadGame)).filter(Objects::nonNull)
                    .filter((saveGame -> saveGame.getUser().equals(user)))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveGame(SaveGame game) {
        File file = new File(path + game.getUser() + EXTENSION);

        try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outStream.writeObject(game);
            System.out.println("Game saved." + game.getUser());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
