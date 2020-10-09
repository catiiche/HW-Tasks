package com.ifmo.jjd.hw6;

import com.ifmo.jjd.Lesson6.Author;

public class Climber {
    private String name;
    private String address;

    public Climber(String name, String address) {
        setName(name);
        setAddress(address);
    }

    public void setName(String name) {
        if (name == null || name.length() < 3)
            throw new IllegalArgumentException("name должен быть не меньше 3");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() < 5)
            throw new IllegalArgumentException("address должен быть не меньше 5");
        this.address = address;
    }
}
