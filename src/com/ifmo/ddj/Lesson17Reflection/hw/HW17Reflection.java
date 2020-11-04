package com.ifmo.ddj.Lesson17Reflection.hw;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class HW17Reflection {
    public static void main(String[] args) throws IllegalAccessException {
        int[] arr = new int[]{1, 2, 3};
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        Book b = new Book(100, "Book", 12.2);
        Integer integer = 1;

        System.out.println(HW17Reflection.toString(arr));
        System.out.println(HW17Reflection.toString(integer));
        System.out.println(HW17Reflection.toString(b));
        System.out.println(HW17Reflection.toString(arrList));
    }

    /*
    Написать рефлексивный public static String toString(Object o),
    который принимает на вход объект и выводит информацию по его свойствам в формате:
     имя свойства - значение свойства
     */
    public static String toString(Object o) {
        StringBuilder sb = new StringBuilder();

        Field[] fields = o.getClass().getDeclaredFields();
        if (o.getClass().isArray()) {
            int length = Array.getLength(o);
            sb.append("имя поля: ");
            sb.append(o.getClass().getName());
            sb.append("\n");
            sb.append("значение: ");
            sb.append("[");
            for (int i = 0; i < length; i++) {
                if (i != 0)
                    sb.append(", ");
                sb.append(Array.get(o, i));
            }
            sb.append("]");
        } else {
            for (Field field : fields) {
                field.setAccessible(true);
                sb.append("имя поля: ");
                sb.append(field.getName());
                sb.append(" значение: ");
                try {
                    sb.append(field.get(o));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    static class Book {
        public int cntPAge = 12;
        public String name;
        public Double price;

        public Book(int cnt, String name, Double price) {
            this.cntPAge = cnt;
            this.name = name;
            this.price = price;
        }
    }
}

