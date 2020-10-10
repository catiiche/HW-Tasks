package com.ifmo.jjd.hw6pt2;

public class App {
    public static void main(String[] args) {

        NutritionalValue apple = new NutritionalValue("apple", 56.5, 45.2,8);
        NutritionalValue pineapple = new NutritionalValue("pineapple",  4558);
        NutritionalValue porridge = new NutritionalValue("porridge", 56.5, 45,8,568);
        NutritionalValue cabbage = new NutritionalValue("cabbage", 458);

        NutritionalValue[] example = {apple, pineapple, porridge, cabbage, null};

        MyProducts checkList = new MyProducts(example);
        checkList.addProduct(new NutritionalValue("cherry", 60,60,1,1));
        checkList.printMyProducts();
    }
}
