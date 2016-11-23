package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.exception.WrongZipFileException;

import java.io.IOException;


/**
 Чтобы узнать какую команду сейчас хочет выполнить пользователь, добавим метод Operation
 askOperation() в класс Archiver. Этот метод должен вывести в консоль список доступных команд и
 попросить выбрать одну из них. Для удобства будем просить ввести номер команды, где номер – это
 порядковый номер команды в enum Operation. Получить порядковый номер значения в enum’е можно с
 помощью метода ordinal().
 Теперь все готово чтобы переписать main, используя последние достижения науки и техники, а именно
 класс CommandExecutor и метод askOperation().

 2.	Перепиши метод main():
 2.1. Объяви локальную переменную типа Operation
 2.2. В цикле запрашивай новое значение для переменной п.2.1. с помощью метода askOperation() и
 вызывай выполнение операции с помощью CommandExecutor.execute()
 2.3. Обеспечь выход из цикла, если пользователь выбрал операцию Operation.EXIT
 2.4. Оберни вызов askOperation() и execute(operation) в блок try-catch. Если произойдет
 исключение WrongZipFileException выведи сообщение "Вы не выбрали файл архива или
 выбрали неверный файл." с помощью ConsoleHelper, при любых других исключениях
 выводи "Произошла ошибка. Проверьте введенные данные.".
 2.5. Проследи, чтобы программа продолжила свою работу (перешла на новый шаг цикла),
 после обработки исключений.
 3.	Запусти программу и проверь, что команда “выход” работает.
 */
public class Archiver
{
    public static void main(String[] args) throws Exception
    {
        Operation operation = null;
        while (true)
        {
            try
            {
                operation = askOperation();
                CommandExecutor.execute(operation);
            }
            catch(WrongZipFileException e)
            {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            }
            catch(Exception e)
            {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
            if (Operation.EXIT.equals(operation))
                break;
        }
        /*
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

        Command exitCommand = new ExitCommand();
        exitCommand.execute();
        */
    }

    /**
     1.	Добавь публичный статический метод Operation askOperation() throws IOException в класс Archiver.
     Он должен:
     1.1. Использовать методы класса ConsoleHelper
     1.2. Запрашивать у пользователя номер операции, которую он хочет совершить. Подсказка:
     чтобы вывести номер операции «Создать архив», используй: Operation.CREATE.ordinal()
     1.3. Возвращать выбранную операцию.
     Пример вывода метода askOperation():
     Выберите операцию:
     0 - упаковать файлы в архив
     1 - добавить файл в архив
     2 - удалить файл из архива
     3 - распаковать архив
     4 - просмотреть содержимое архива
     5 – выход

     1.1. Создать архив CREATE
     1.2. Добавить файл в архив ADD
     1.3. Удалить файл из архива REMOVE
     1.4. Извлечь содержимое архива EXTRACT
     1.5. Просмотреть содержимое архива CONTENT
     1.6. Выйти из программы EXIT
     */

    public static Operation askOperation() throws IOException
    {
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(Operation.CREATE.ordinal() + " - упаковать файлы в архив");
        ConsoleHelper.writeMessage(Operation.ADD.ordinal() + " - добавить файл в архив");
        ConsoleHelper.writeMessage(Operation.REMOVE.ordinal() + " - удалить файл из архива");
        ConsoleHelper.writeMessage(Operation.EXTRACT.ordinal() + " - распаковать архив");
        ConsoleHelper.writeMessage(Operation.CONTENT.ordinal() + " - просмотреть содержимое архива");
        ConsoleHelper.writeMessage(Operation.EXIT.ordinal() + " - выход");

        int opNumber = ConsoleHelper.readInt();

        return Operation.values()[opNumber];
    }
}
