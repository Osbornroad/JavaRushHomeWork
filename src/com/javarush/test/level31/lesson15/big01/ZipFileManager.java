package com.javarush.test.level31.lesson15.big01;

import java.nio.file.Path;

/**
 1.	Создай класс менеджер ZipFileManager
 2.	Добавь в класс приватную переменную Path zipFile. В ней мы будем хранить полный путь к архиву,
 с которым будем работать.
 3.	Добавь конструктор ZipFileManager(Path zipFile). Проинициализируй поле класса zipFile.
 4.	Объяви публичный метод createZip(Path source) throws Exception, пока с пустой реализацией.
 Path source – это путь к чему-то, что мы будем архивировать.
 */
public class ZipFileManager
{
    private Path zipFile;

    public ZipFileManager(Path zipFile)
    {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception
    {

    }
}
