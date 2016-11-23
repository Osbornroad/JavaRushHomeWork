package com.javarush.test.level31.lesson15.big01;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 Сейчас мы напишем реализацию метода createZip(Path source), в котором мы будем архивировать файл,
 заданный переменной source.
 В Java есть специальный класс ZipOutputStream из пакета java.util.zip, который сжимает (архивирует)
 переданные в него данные. Чтобы несколько файлов, сжимаемые в один архив, не слиплись вместе, для
 каждого из них создается специальная сущность – элемент архива ZipEntry. Т.е. в ZipOutputStream мы
 сначала кладем ZipEntry, а затем уже записываем содержимое файла. При записи файл автоматически
 сжимается, а при чтении – автоматически восстанавливается. ZipEntry может быть не только файлом, но и
 папкой.
 Чтобы заархивировать файл (создать новый архив и добавить в него файл):
 1.	Создай новый поток архива ZipOutputStream используя перемнную класса zipFile, с помощью метода
 newOutputStream класса Files.
 2.	Создай новый элемент архива ZipEntry. В конструктор ZipEntry передай строку, содержащую имя новой записи.
 Имя нужно получить из полного пути source, взять только имя файла и сконвертировать его в String.
 3.	Добавь в поток архива созданный элемент архива.
 4.	Перепиши данные из файла, который архивируем в поток архива. Для этого:
 4.1. создай поток InputStream для добавляемого файла source, используя метод newInputStream класса Files
 4.2. сделай цикл, который будет читать данные из InputStream (созданного в п.4.1), пока они там есть и записывать
 их в ZipOutputStream (созданный в п.1)
 4.3. закрой InputStream, сделай это с помощью try-with-resources
 5.	Закрой элемент архива у потока архива
 6.	Закрой поток архива, сделай это также с помощью try-with-resources
 7.	Запусти программу и проверь, что файл архивируется
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
        try(ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile)))
        {
            ZipEntry entry = new ZipEntry(source.getFileName().toString());
            zos.putNextEntry(entry);
            byte[] buffer = new byte[1024];
            try (InputStream inputStream = Files.newInputStream(source))
            {
                while (inputStream.available() > 0)
                {
                    int size = inputStream.read(buffer);
                    zos.write(buffer, 0, size);
                }
            }
            zos.closeEntry();
        }

    }
}
