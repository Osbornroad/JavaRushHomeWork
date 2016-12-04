package com.javarush.test.level33.lesson15.big01;

/**
 Добавь в него статический метод log(Exception e), который будет выводить
 краткое описание исключения.
 */
public class ExceptionHandler {
    public static void log(Exception e)
    {
        System.out.println(e.toString());
    }
}
