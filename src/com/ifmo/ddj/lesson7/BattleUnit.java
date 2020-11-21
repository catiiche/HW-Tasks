package com.ifmo.ddj.lesson7;

//extends -  наследование()
//множественное наследование запрещено
//класс BattleUnit (дочерний класс) наследуется от класса Unit (родительский класс)
//Дочерний класс получает доступ ко всем свойствам и методам родительского класса
//если бы был модификатор privat - не были бы доступны
//или package privat - дефолтные
//конструктор дочернего не обязательно должен совпадать с родительском


import java.io.Serializable;

//BattleUnit унаследовал обязанность реализации интерфейса
abstract public class BattleUnit
        extends Unit
        implements AttackAble {
    protected int attackPoints;

//alt + enter - create constructor
//  в родительском классе затерт конструктор по умолчанию, поэтому в дочернем классе обязаны вызвать минимум 1 доступный конструктор родительского
//    и передать в него параметры
    public BattleUnit(int healthPoints, int agilityPoints, int attackPoints) {
        super(healthPoints, agilityPoints); //вызов конструктора родителя
        if (attackPoints <= 0)
            throw new IllegalArgumentException("attackPoints <= 0");
        this.attackPoints = attackPoints;
    }


    //    класс BattleUnit реализует (имплементирует) интерфейс
//    RestAble и AttackAble, в которых есть методы run  с реализацией
//    в такой ситуации мы обязаны явно указать какой метод выбрать (alt+enter - implements - выбираем метод
    @Override // аннотация , видим мы и компилятор
    public void run() {
        System.out.println(("Реализация run BattleUnit"));
    }

    public static BattleUnit unitFactory(){
        String[] types = {"knight", "infantry"};
        BattleUnit unit = null;
        switch (types[(int) (Math.random() * types.length)]) {
            case "knight":
                unit = new Knight(
                                (int) (Math.random() * 41) + 10,
                                (int) (Math.random() * 11) + 5,
                                (int) (Math.random() * 11) + 8
                        );
                break;
            case "infantry":
                unit = new Infantry(
                        (int) (Math.random() * 41) + 20,
                        (int) (Math.random() * 11) + 5,
                        (int) (Math.random() * 11) + 5
                );
                break;
        }
        return unit;
    }

}
