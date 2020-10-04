package Lesson5;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkL5 {
    public static void main(String[] args) {
        task1();
        //task2();
        //task3();
        //task4();
        //task5();
    }

    public static void task1() {
        /* Заполнить массив
Задать массив на N слов.
В цикле считывать с консоли слова (scanner.nextLine()), и добавлять их в массив
(добавлять новое слово в массив можно только, если в нем его еще нет).
В итоге в массиве будут только уникальные слова.
Выход из программы по слову exit (его в массив не добавлять) или если массив заполнен
Перед завершением программы, вывести получившийся массив в консоль */
        String[] array = new String[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово для заполнения массива. Для выхода из программы введите \"exit\".");

        for (int i = 0; i < array.length; i++) {
            String word = scanner.nextLine();
            boolean flag = true;

            if (word.toLowerCase().equals("exit")) break;

            for (String s : array) {
                if (word.equals(s)) {
                    flag = false;
                    i--;
                    break;
                }
            }
            if (flag == true) array[i] = word;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void task2() {
        /* Найти количество вхождений одной строки в другую.
Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза */
        String str = "дом, домик, домой, одомашненный";
        int s = str.split("дом").length - 1;
        System.out.println(s);
    }

    public static void task3() {
        /*Написать функцию, которая проверяет, является ли строка палиндромом.
Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются по буквам или по словам как слева направо, так и справа налево.
Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром*/
        System.out.println("Введите слово, текст или число.");
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        str = str.replaceAll("\\s+", "");

        String[] arrayStr = str.split("");
        String[] arrayStrSort = new String[arrayStr.length];

        int cnt = 0;
        for (int i = arrayStr.length - 1; i >= 0; i--) {
            arrayStrSort[cnt] = arrayStr[i];
            cnt++;
        }

        boolean flag = true;
        for (int i = 0; i < arrayStr.length; i++) {
            if (!(arrayStr[i].equalsIgnoreCase(arrayStrSort[i]))) {
                flag = false;
                break;
            }
        }
        if (flag) System.out.println("Это палиндром");
        else System.out.println("Это не палиндром");
    }

    public static void task4() {
        /*Заменить все буквы в слове на строчные, а первую букву на заглавную
Например, дано hello, получаем Hello / дано HeLLO, получаем Hello*/
        String word = "HeLLO";
        StringBuilder sb = new StringBuilder("");
        String[] array = word.split("");

        for (int i = 0; i < array.length; i++) {
            if (i == 0) array[i] = array[i].toUpperCase();
            else array[i] = array[i].toLowerCase();

            sb.append(array[i]);
        }
        word = sb.toString();
        System.out.println(word);
    }

    public static void task5() {
        /*Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины
Например, в "в предложении все слова разной длины" самое длинное слово "предложении"*/
        String str = "в предложении все слова разной длины";
        String[] strArr = str.split(" ");

        int max = strArr.length;
        int index = 0;

        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i].length() > max) {
                max = strArr[i].length();
                index = i;
            }
        }
        System.out.println(strArr[index]);
    }
}
