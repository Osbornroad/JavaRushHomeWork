package com.javarush.test.level31.lesson15.big01;

/**
 Создадим класс FileProperties, который будет отвечать за свойства каждого файла в архиве. Свойства – это
 набор, состоящий из: имя файла, размер файла до и после сжатия, метод сжатия.
 1.	Создай класс FileProperties
 2.	Добавь в него приватные переменные класса:

 2.1. Имя String name
 2.2. Размер в байтах long size
 2.3. Размер после сжатия в байтах long compressedSize
 2.4. Метод сжатия int compressionMethod

 3.	Добавь сеттеры и гетеры для них

 4.	Добавь конструктор FileProperties(String name, long size, long compressedSize, int
 compressionMethod)

 5.	Добавь метод long getCompressionRatio(), который будет считать степень сжатия по формуле:
 100 - ((compressedSize * 100) / size)

 6.	Перегрузи метод String toString(), чтобы он возвращал строку по шаблону: “name size Kb
 (compressedSize Kb) сжатие: compressedSize%”, если размер size больше нуля, иначе он должен
 вернуть только имя файла. Нулевой размер может быть, например, у директории. Не забудь
 перевести байты в килобайты, а их не столько же, сколько граммов в килограмме, и даже не
 столько, сколько блинов у меня на столе… Хм, похоже мне пора перекусить…
 */
public class FileProperties
{
    private String name;
    private long size;
    private long compressedSize;
    private int compressionMethod;

    public long getCompressionRatio()
    {
        return 100 - ((compressedSize * 100) / size);
    }

    @Override
    public String toString()
    {
        return (size > 0) ? (String.format("%s %f Kb(%f Kb) сжатие: %d%%", name, size / 1024 * 1.0f, compressedSize / 1024 * 1.0f, getCompressionRatio())) : name;
    }

    public FileProperties(String name, long size, long compressedSize, int compressionMethod)
    {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getSize()
    {
        return size;
    }

    public void setSize(long size)
    {
        this.size = size;
    }

    public long getCompressedSize()
    {
        return compressedSize;
    }

    public void setCompressedSize(long compressedSize)
    {
        this.compressedSize = compressedSize;
    }

    public int getCompressionMethod()
    {
        return compressionMethod;
    }

    public void setCompressionMethod(int compressionMethod)
    {
        this.compressionMethod = compressionMethod;
    }
}
