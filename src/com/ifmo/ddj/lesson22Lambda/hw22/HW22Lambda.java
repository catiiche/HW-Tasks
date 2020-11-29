package com.ifmo.ddj.lesson22Lambda.hw22;

import java.util.function.*;

public class HW22Lambda {
    public static void main(String[] args) {
        Predicate<String> startWith = word -> word.startsWith("a");
        Predicate<String> contains = word -> word.contains("cat");
        Predicate<Integer> isPositive = num -> num > 0;

        System.out.println("Predicate: " + startWith.test("avocado")); // true
        System.out.println("Predicate: " + contains.test("Cat")); // true
        System.out.println("Predicate: " + isPositive.test(89)); // true

        Function<Integer, String> convert = x -> String.valueOf(x) + " рублей";
        System.out.println("Function: " + convert.apply(50));

        // converts cm to mm
        Function<Integer, Integer> measure = x -> x * 10;
        int result1 = measure.apply(10);
        System.out.println("Function: " + result1);

        // returns half of number
        Function<Integer, Double> makeHalf = a -> a / 2.0;
        System.out.println("Function: " + makeHalf.apply(10));

        Function<Integer, Integer> square = x -> x * x;
        UnaryOperator<Integer> xor = a -> a ^ 1;
        int result2 = xor
                .compose(square)
                .apply(30);
        System.out.println("UnaryOperator: " + result2);

        UnaryOperator<String> str = a -> a.replace("a", "u");
        System.out.println("UnaryOperator: " + str.apply("abrakadabra"));

        UnaryOperator<Integer> changeValue = a -> a * a;
        UnaryOperator<Integer> changeValue2 = a -> a + a;
        int res = changeValue
                .compose(changeValue2)
                .andThen(changeValue)
                .apply(1);
        System.out.println("UnaryOperator: " + res);

        BinaryOperator<Integer> maxBy = (a, b) -> {
            if (a > b)
                return a;
            else return b;
        };

        System.out.println("BinaryOperator: " + maxBy.apply(8, 7));

        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        System.out.println("BinaryOperator: " + multiply.apply(120, 1452));

        Consumer<String> upperA = x -> System.out.println("Consumer: " + x.replace("a", "A"));
        upperA.accept("alien");

        Consumer<String> strip = x -> System.out.println("Consumer: " + x.trim());
        strip.accept("       chocolate " + "cake ");
    }
}
