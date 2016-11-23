package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.command.Command;
import com.javarush.test.level31.lesson15.big01.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 В самом конце метода main в класса Archiver добавь код, который создает объект типа
 ExitCommand и вызывает у него метод execute()
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

        Command exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}
