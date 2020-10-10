package com.ifmo.jjd.hw6pt2;

import java.util.Arrays;

public class MyProducts {
    private final static double permittedProteins = 50;
    private final static double permittedFats = 20;
    private final static double permittedCarbs = 20;
    private final static int permittedCalories = 200;
    private NutritionalValue[] products;

    public MyProducts(NutritionalValue[] products) {
        this.products = products;
    }

    public double getPermittedProteins() {
        return permittedProteins;
    }

    public double getPermittedFats() {
        return permittedFats;
    }

    public double getPermittedCarbs() {
        return permittedCarbs;
    }

    public int getPermittedCalories() {
        return permittedCalories;
    }

    public NutritionalValue[] getProducts() {
        return products;
    }

    public void addProduct(NutritionalValue product) {
        if (product.getCalories() > permittedCalories || product.getCarbs() > permittedCarbs || product.getFats() > permittedFats || product.getProteins() > permittedProteins) {
            System.out.println(product.getName() + " не разрешен!");
        return;
        }
        else{
            for (int i = 0; i < products.length; i++) {
                if (products[i] == null) {
                    products[i] = product;
                    return;
                }
            }
        }
        System.out.println("список продуктов полон " + product.getName() + " не добавлен");
    }

    public void printMyProducts() {
        System.out.println("Ваш список разрешенных продуктов: " + Arrays.toString(products));
    }
}

