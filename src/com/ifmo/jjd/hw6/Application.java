package com.ifmo.jjd.hw6;

public class Application {
    public static void main(String[] args) {

        Mountain mountain1 = new Mountain("Demerji", "Russia", 1356);
        Mountain mountain2 = new Mountain("Mont Blanc","Italy", 4810);
        Mountain mountain3 = new Mountain("Chimtarga","Tajikistan", 5489);

        Climber[] climbers1 = {
                new Climber("Ivan", "Saint-Petersburg"),
                new Climber("Sonya", "Moscow"),
                new Climber("Alexey", "Ivanovo")
        };
        Climber[] climbers2 = {
                new Climber("Igor", "Saint-Petersburg"),
                new Climber("Tonya", "Moscow")
        };
        Climber[] climbers3 = {
                new Climber("Lisa", "Saint-Petersburg"),
                new Climber("Anna", "Moscow")
        };

        GroupForClimbing group1 = new GroupForClimbing(false, mountain1,climbers1);
        GroupForClimbing group2 = new GroupForClimbing(false, mountain2,climbers2);
        GroupForClimbing group3 = new GroupForClimbing(false, mountain3,climbers3);
    }
}
