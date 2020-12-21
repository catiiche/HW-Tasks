package com.itmo.shkuratova.coursework3;

public class ForestDwellers implements Command {
    @Override
    public void execute() {
        System.out.println("Пока Лисёнок принимал решение, лесные жители разошлись кто куда.\n"
                + "Остались только Сова и Волк. Но у Совы бывают проблемы с памятью,\n"
                + "а Волк может сильно разозлиться из-за расспросов.\n"
                + "Кого выбрать?");
    }

    @Override
    public Integer printMenu() {
        return null;
    }
}
