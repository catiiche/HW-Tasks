package com.ifmo.ddj.Lesson17Reflection.hw.Annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HW17Annotation {
    /*Создать объект, установить значение свойств, вызвать метод, используя рефлексию:
Если класс аннотирован @Config, создать экземпляр данного класса
Если поле данного класса аннотировано @Required, установить значение свойства через сеттер для ранее созданного объекта (имя сеттера = 'set' + ИмяСвойства)
Вызвать метод toString у ранее созданного объекта
     */
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Human human = HW17Annotation.useAnnotationConfig();
        HW17Annotation.useAnnotationRequired(human);

        Class<? extends Human> humanClass = Human.class;
        Method method = humanClass.getDeclaredMethod("toString");
        method.setAccessible(true);
        method.invoke(human);
    }

    public static Human useAnnotationConfig() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, NoSuchMethodException {
        Class<? extends Human> humanClass = Human.class;

        if (humanClass.isAnnotationPresent(Config.class)) {
            Constructor<? extends Human> humanConstructor = humanClass
                    .getDeclaredConstructor(String.class, int.class);
            return humanConstructor.newInstance("George", 45);
        }
        return null;
    }

    public static void useAnnotationRequired(Human human) throws IllegalAccessException, InvocationTargetException, NoSuchFieldException, NoSuchMethodException {
        Class<? extends Human> humanClass = Human.class;
        Field humanField = humanClass.getDeclaredField("name");
        if (humanField.isAnnotationPresent(Required.class)) {
            Method method = humanClass.getDeclaredMethod("setName", String.class);
            method.invoke(human, "Ivan");
        }
    }
}
