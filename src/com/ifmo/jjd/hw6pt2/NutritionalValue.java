package com.ifmo.jjd.hw6pt2;

public class NutritionalValue {
    private String name;
    private double proteins;
    private double fats;
    private double carbs;
    private int calories;

//  конструктор 1
    public NutritionalValue(String name, double proteins, double fats, double carbs) {
        setName(name);
        setProteins(proteins);
        setFats(fats);
        setCarbs(carbs);
    }

//  конструктор 2
    public NutritionalValue(String name, int calories) {
        setName(name);
        setCalories(calories);
    }

//  конструктор 3
    public NutritionalValue(String name, double proteins, double fats, double carbs, int calories) {
        setName(name);
        setProteins(proteins);
        setFats(fats);
        setCarbs(carbs);
        setCalories(calories);
    }

//    конструктор 4
    public NutritionalValue(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 4)
            throw new IllegalArgumentException("name должен быть не меньше 4");
        this.name = name;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        if (proteins <= 0)
            throw new IllegalArgumentException("количество белка должно быть больше 0");
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        if (fats <= 0)
            throw new IllegalArgumentException("количество жира должно быть больше 0");
        this.fats = fats;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        if (carbs <= 0)
            throw new IllegalArgumentException("количество углеводов должно быть больше 0");
        this.carbs = carbs;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        if (calories <= 0)
            throw new IllegalArgumentException("количество калорий должно быть больше 0");
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "NutritionalValue{" +
                "name='" + name + '\'' +
                '}';
    }
}
