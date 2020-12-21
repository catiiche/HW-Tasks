package com.itmo.shkuratova.coursework3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Fox implements Command {
    Game game;
    List<Command> commands = new ArrayList<>();
    Receiver receiver;
    ExitGame exit;
    SaveGame save;

    public Fox() {
        commands.add(new Search());
        commands.add(new Home());

    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Integer printMenu() {
        System.out.println("Введите команду:\n"
                + "поиск - отправиться на поиски\n"
                + "домой - вернуться домой\n"
                + "save - сохранить игру\n"
                + "exit - выйти из игры");

        while (true) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                if (reader.readLine().equalsIgnoreCase("поиск")) {
                    return 0;
                } else if (reader.readLine().equalsIgnoreCase("домой")) {
                    return 1;
                } else if (reader.readLine().equalsIgnoreCase("save")) {
                    save.saveGame(this.receiver);

                } else if (reader.readLine().equalsIgnoreCase("exit")) {
                    exit.execute();
                } else System.out.println("Неправильный ввод. Введите поиск или домой.");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } ///добавить третий вариант сохранить и выйти для ввода
    }

    @Override
    public void execute() {
        System.out.println("Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. "
                + "Это утро не было исключением.\n" + "Лисёнок пришёл на их обычное место встречи, "
                + "но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга..\n"
                + "Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду\" - подумал Лисёнок.\n"
                + "Как поступить Лисенку?");

        int i = this.printMenu();
        this.commands.get(i);
        receiver.addCommand(this);
    }
}
