package com.javarush.test.level31.lesson15.big01;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 1.	Создай класс FileManager с конструктором FileManager(Path rootPath) throws IOException
 2.	Объяви и проинициализируй приватные переменные класса:
 2.1. Path rootPath – корневой путь директории, файлы которой нас интересуют
 2.2. List<Path> fileList – список относительных путей файлов внутри rootPath
 3.	Создай геттер для fileList
 4.	Реализуй метод void collectFileList(Path path) throws IOException, который должен:
 4.1. Проверить, если переданный путь path является обычным файлом (используй метод
 Files.isRegularFile), то получить его относительный путь относительно rootPath
 и добавить его в список fileList.

 4.2. Если переданный путь path, является директорией (узнать это поможет метод
 Files.isDirectory), то пройтись по всему содержимому директории и вызвать
 collectFileList(Path path), передав в path обнаруженные элементы.
 Пройтись по всему содержимому директории можно предварительно получив DirectoryStream с помощью метода
 newDirectoryStream класса Files. Не забудь закрыть созданный DirectoryStream.

 5.	Добавь вызов метода collectFileList(rootPath) в конструкторе FileManager.
 6.	Примени все свом знания об инкапсуляции к этому классу.
 */
public class FileManager
{
    private Path rootPath;
    private List<Path> fileList = new ArrayList<>();

    public FileManager(Path rootPath) throws IOException
    {
        this.rootPath = rootPath;
        collectFileList(this.rootPath);
    }

    public List<Path> getFileList()
    {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException
    {
        if (Files.isRegularFile(path))
        {
            Path file = rootPath.relativize(path);
            fileList.add(file);
        }
        else if (Files.isDirectory(path))
        {
            try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path))
            {
                for (Path entry : directoryStream)
                    collectFileList(entry);
            }
        }
    }
}
