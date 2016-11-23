package com.javarush.test.level31.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 5.	Создай класс Archiver и добавь в него метод main.
 6.	В методе main:
 6.1 Запроси пользователя ввести полный путь архива с клавиатуры. Не забудь, что имя тоже
 входит в состав полного пути.
 6.2 Создай объект класса ZipFileManager, передав в него имя файла архива. Разберись, как из
 String получить Path. Подсказка: изучи метод get() класса Paths.
 6.3 Запроси пользователя ввести путь к файлу, который будем архивировать. Не путай это с
 файлом архива, который мы уже ввели. На этот раз нам нужен файл, который мы будем
 сжимать, а не в котором хранить сжатые данные.
 6.4 Вызови метод createZip у объекта ZipFileManager, передав в него путь для архивации.
 */
public class Archiver
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Please, input full path for archive.");
        Path archive;
        Path file;
        ZipFileManager fileManager;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String archiveName = reader.readLine();
        archive = Paths.get(archiveName);
        fileManager = new ZipFileManager(archive);

        System.out.println("Please, input full path for file.");
        String fileName = reader.readLine();
        file = Paths.get(fileName);
        fileManager.createZip(file);

    }
}
