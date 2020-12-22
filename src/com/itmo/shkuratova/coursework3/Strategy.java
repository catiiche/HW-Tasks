package com.itmo.shkuratova.coursework3;

import java.util.List;

public interface Strategy {
    List<SaveGame> getSaveList(String user);

    void saveGame(SaveGame game);
}
