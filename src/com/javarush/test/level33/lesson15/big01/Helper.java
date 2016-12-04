package com.javarush.test.level33.lesson15.big01;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Натусик on 03.12.2016.
 */
public class Helper {
    /**
     4.1.1.	Добавь в него статический метод String generateRandomString(), который
     будет генерировать случайную строку. Воспользуйся для этого классами
     SecureRandom и BigInteger. Подсказка: гугли запрос "random string java".
     */
    public static String generateRandomString()
    {
        return new BigInteger(130, new SecureRandom()).toString();
    }
    /**
     4.1.2.	Добавь в класс статический метод printMessage(String message). Он должен выводить
     переданный текст в консоль. Весь дальнейший вывод в программе должен
     быть реализован через этот метод!
     */
    public static void printMessage(String message)
    {
        System.out.println(message);
    }
}
