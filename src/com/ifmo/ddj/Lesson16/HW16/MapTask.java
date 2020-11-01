package com.ifmo.ddj.Lesson16.HW16;

import com.ifmo.ddj.Lesson16.User;

import java.text.DecimalFormat;
import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который принимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";
        getByLogin(firstTaskMap, city);


        // TODO:: дан список слов (words).
        //  Написать метод, который будет возвращать количество
        //  одинаковых слов в списке
        //  в виде Map<String, Integer>,
        //  где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        countEqualsWords(words);


        // TODO:: дана мапа (customerMap).
        //  Написать метод, который принимает на вход агрументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели,
        //  возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        getByAge(customerMap, 47, 68);


        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        getFrequency(text, "still");
        countLetter(text);

        popularWords(text);

        alphabet(text);

    }

    // 1
    public static List<String> getByLogin(HashMap<String, String> firstTaskMap, String city) {
        List<String> newList = new ArrayList<>();
        for (Map.Entry<String, String> pair : firstTaskMap.entrySet()) {
            if (pair.getValue().equals(city))
                newList.add(pair.getKey());
        }
        System.out.println(newList);
        return newList;
    }

    // 2
    public static Map<String, Integer> countEqualsWords(List<String> words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            if (wordsMap.containsKey(word))
                wordsMap.put(word, wordsMap.get(word) + 1);
            else wordsMap.put(word, 1);
        }
        System.out.println(wordsMap);
        return wordsMap;
    }

    // 3
    public static HashMap<String, Customer> getByAge(
            HashMap<String, Customer> map,
            int from, int to
    ) {
        HashMap<String, Customer> newMap = new HashMap<>();
        for (Map.Entry<String, Customer> entry : map.entrySet()) {
            if (entry.getValue().getAge() >= from &&
                    entry.getValue().getAge() < to) {
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println(newMap);
        return newMap;
    }

    // 4
    // формируем ArrayList из слов text
    public static ArrayList<String> createList(String text) {
        String[] words = text.split("\\s");
        ArrayList<String> textList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            textList.add(words[i]);
        }
        return textList;
    }

    // 4.1
    public static int getFrequency(String text, String word) {
        ArrayList<String> textList = createList(text);

        HashMap<String, Integer> freqWords = new HashMap<>();
        for (String s : textList) {
            if (freqWords.containsKey(s))
                freqWords.put(s, freqWords.get(s) + 1);
            else freqWords.put(s, 1);
        }

        if (freqWords.containsKey(word)) {
            System.out.println(word + " " + freqWords.get(word));
            return freqWords.get(word);
        } else System.out.println("Слово не встречается в тексте");
        return 0;
    }

    // 4.2
    public static HashMap<Integer, ArrayList<String>> countLetter(String text) {
        ArrayList<String> textList = createList(text);
        HashMap<Integer, ArrayList<String>> countLetter = new HashMap<>();

        for (String s : textList) {
            if (!countLetter.containsKey(s.length()))
                countLetter.put(s.length(), new ArrayList<String>());
            countLetter.get(s.length()).add(s);
        }
        System.out.println(countLetter);
        return countLetter;
    }

    // 4.3
    public static void popularWords(String text) {
        ArrayList<String> textList = createList(text);

        HashMap<String, Integer> mapWords = new HashMap<>();
        for (String s : textList) {
            if (mapWords.containsKey(s))
                mapWords.put(s, mapWords.get(s) + 1);
            else mapWords.put(s, 1);
        }

        HashMap<String, Integer> popularWords = new HashMap<>();

        for (int i = 0; i < 10; i++) {

            int max = 0;
            String s = "";
            for (Map.Entry<String, Integer> pair : mapWords.entrySet()) {
                if (pair.getValue() > max) {
                    max = pair.getValue();
                    s = pair.getKey();
                }

            }
            popularWords.put(s, max);
            mapWords.remove(s, max);

        }
        System.out.println(popularWords);
    }

    // 4.4
    public static void alphabet(String text) {
        text = text.replaceAll("\\s", "");
        text = text.replaceAll("-", "");
        char[] str = text.toCharArray();

        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            characters.add(str[i]);
        }

        HashMap<Character, Integer> alphabetFreq = new HashMap<>();
        for (Character c : characters) {
            if (alphabetFreq.containsKey(c))
                alphabetFreq.put(c, alphabetFreq.get(c) + 1);
            else alphabetFreq.put(c, 1);
        }

        for (Map.Entry<Character, Integer> pair : alphabetFreq.entrySet()) {
            Double countPercent = (double) pair.getValue() / characters.size() * 100.0;
            DecimalFormat dec = new DecimalFormat("#0.00");

            System.out.println(pair.getKey() + " частота встречаемости в данном тексте " + dec.format(countPercent) + " %");
        }
    }
}
