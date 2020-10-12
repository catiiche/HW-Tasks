package com.ifmo.jjd.Lesson9;

public class App {
        public static void main(String[] args) {
            Author ivan = new Author("Иван", "Петров");
            Author anna = new Author("Анна", "Гришкова");

            ColouringBook cars = new ColouringBook("Машинки", 23, 15);
            cars.setAuthor(ivan);

            ColouringBook robots = new ColouringBook("Роботы", 38, 19);
            robots.setAuthor(ivan);

            ColouringBook flowers = new ColouringBook("Цветы", 12, 10);
            flowers.setAuthor(anna);

//            все классы наследуются от класса Object, а значит у всех классов по умолчанию доступны методы класса
//            Object. Можно работать с ним как с общим типом данных

            //Object obj = new Object();
            //Object author = new Author("Ivan", "Petrov") //потеряет свои методы

//            toString()
            System.out.println(ivan.toString());
            System.out.println(flowers.toString()); // pageCount 10 -  как в дочернем  если не прописать в классе ColouringBook

            /*
            public String toString() {
                return "ColouringBook{" +
                        " picsCount=" + picsCount +
                        " pageCount=" + getPageCount() +
                        " title=" + getTitle() +
                        " author=" + getAuthor()+
                        '}'; */

//            equals() и hashcode() используются для сравнения объектов
//            или когда помещаем объекты в хранилища - коллекиции (не в массивы).
//            доступны у любого объекта, т.к. определены  в Object
//            переопределять надо оба метода

            Author author1 = new Author("Михаил", "Петров");
            Author author2 = new Author("Михаил", "Петров");

            System.out.println(author1 == author2); //false | для всех ссылочных происходит сравнение ссылок
            System.out.println(author1.equals(author2)); //false | для сравнения ссылочных объектов ( кроме массивов)
//            реализация equals по умолчанию  сравнивает ссылки на объект
//            поэтому переопределяем в классе объекты которого будем сравнивать альт +инсерт

//            equals()
//            объект всегда равен самому себе(рефлективность)
//            a.equals(b) то и b.equals(a) (симметричность)
//            a.equals(b) и b.equals(с) то  a.equals(с ) (транзитивность)
//            сколько бы раз не вызывался equals без изменения состояния объекта,
//            результат должен оставаться неизменным (консистентность)

//            hashCode()
//            если объекты равны по  equals(), то hashCode должен вернуть одинаковое значение
//            для обоих объектов

//            если объекты не равны по equals(), то hashCode должен вернуть одинаковое значение
//            для обоих объектов

//            если состояние объектов не меняется - hashCode должен возвращать одинаковый результат

            System.out.println(author1.hashCode());
            System.out.println(author2.hashCode());


            ColouringBook colouring1 = new ColouringBook("Роботы", 38, 19);
            colouring1.setAuthor(ivan);

            ColouringBook colouring2 = new ColouringBook("Роботы", 38, 19);
            colouring2.setAuthor(ivan);

            System.out.println(colouring1.equals(colouring2)); //false -  не переопределен и сравнивает ссылки
//            после переопределения не учитывает свойства родителя

//            Objects.hash(picsCount)  вернет хэшкод объекта










        }
    }
