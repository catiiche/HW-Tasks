package com.itmo.shkuratova.coursework3;

public class Wolf implements Command {
    @Override
    public void execute() {
        System.out.println("Волк оказался вполне дружелюбным, но помочь не смог.\n"
                + "Лишь сказал, что маленькому лисенку не стоит бродить по лесу одному.\n"
                + "И как теперь поступить?");
    }

    @Override
    public Integer printMenu() {
        return null;
    }
}
