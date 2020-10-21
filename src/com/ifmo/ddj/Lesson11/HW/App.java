package com.ifmo.ddj.Lesson11.HW;

import com.ifmo.ddj.Lesson11.Article;

import java.util.Arrays;
import java.util.Scanner;

import static com.ifmo.ddj.Lesson11.HW.Position.*;

public class App {
    /*
enum должностей Position,
класс User со следующими полями: String fulName; int salary; Position position;
несколько массивов, в каждом массиве будут храниться объекты класса User с одинаковыми должностями
Пользователь вводит свои имя, фамилию и первую букву должности. Ваша задача создать объект типа User и поместить его в соответствующий массив.
 */
    public static void main(String[] args) {
        getInform();
        System.out.println(Arrays.toString(InformationStore.director));
    }

    public static void getInform() {
        System.out.println("Введите имя, фамилию и первую букву должности на английском");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        String[] s = answer.split(" ");

        User user = null;

        switch (s[2]) {
            case "D":
                user = new User(s[0] + s[1], DIRECTOR);
                break;
            case "M":
                user = new User(s[0] + s[1], MANAGER);
                break;
            case "C":
                user = new User(s[0] + s[1], CLEANER);
                break;
        }

        switch (user.getPosition()) {
            case DIRECTOR:
                for (int i = 0; i < InformationStore.director.length; i++) {
                    if (InformationStore.director[i] == null)
                        InformationStore.director[i] = user;
                    break;
                }

            case MANAGER:
                for (int i = 0; i < InformationStore.manager.length; i++) {
                    if (InformationStore.manager[i] == null)
                        InformationStore.manager[i] = user;
                    break;
                }
            case CLEANER:
                for (int i = 0; i < InformationStore.cleaner.length; i++) {
                    if (InformationStore.cleaner[i] == null)
                        InformationStore.cleaner[i] = user;
                    break;
                }
        }

    }

}
