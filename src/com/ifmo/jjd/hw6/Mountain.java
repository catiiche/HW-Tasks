package com.ifmo.jjd.hw6;

public class Mountain {
    private String name;
    private String country;
    private int height;

    public Mountain(String name, String country, int height) {
        setName(name);
        setCountry(country);
        setHeight(height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 4)
            throw new IllegalArgumentException("name должен быть не меньше 4");
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.length() < 4)
            throw new IllegalArgumentException("name должен быть не меньше 4");
        this.country = country;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 100)
            throw new IllegalArgumentException("height должен быть не меньше 100");
        this.height = height;
    }
}
