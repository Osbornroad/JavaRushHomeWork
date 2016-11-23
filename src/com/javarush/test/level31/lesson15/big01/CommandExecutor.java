package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.command.*;

import java.util.HashMap;
import java.util.Map;

import static com.javarush.test.level31.lesson15.big01.Operation.*;

/**
 1.	Создай класс CommandExecutor. Он должен быть в корне задачи, не стоит добавлять его в пакет command
 2.	Запрети явный вызов конструктора этого класса
 3.	Добавь в класс приватное статическое константное хранилище команд Map<Operation, Command>
 allKnownCommandsMap
 4.	Проинициализируй переменную allKnownCommandsMap так, чтобы каждому значению из
 Operation соответствовала правильная команда.
 5.	Реализуй публичный статический метод execute(Operation operation) throws Exception, который
 должен брать нужную команду из allKnownCommandsMap и вызывать у нее метод execute.

 1.1. Создать архив CREATE
 1.2. Добавить файл в архив ADD
 1.3. Удалить файл из архива REMOVE
 1.4. Извлечь содержимое архива EXTRACT
 1.5. Просмотреть содержимое архива CONTENT

 2.1. Команда создания архива (упаковки файлов в архив) – class ZipCreateCommand
 2.2. Команда просмотра содержимого архива – class ZipContentCommand
 2.3. Команда распаковки архива – class ZipExtractCommand
 2.4. Команда добавления файла в архив – class ZipAddCommand
 2.5. Команда удаления файла из архива – class ZipRemoveCommand
 */
public class CommandExecutor
{
    private CommandExecutor()
    {
    }

    private static Map<Operation, Command> allKnownCommandsMap;

    static
    {
        allKnownCommandsMap  = new HashMap<Operation, Command>();
        allKnownCommandsMap.put(CREATE, new ZipCreateCommand());
        allKnownCommandsMap.put(ADD, new ZipAddCommand());
        allKnownCommandsMap.put(REMOVE, new ZipRemoveCommand());
        allKnownCommandsMap.put(EXTRACT, new ZipExtractCommand());
        allKnownCommandsMap.put(CONTENT, new ZipContentCommand());
        allKnownCommandsMap.put(EXIT, new ExitCommand());
    }

    public static void execute(Operation operation) throws Exception
    {
        allKnownCommandsMap.get(operation).execute();
    }
}
