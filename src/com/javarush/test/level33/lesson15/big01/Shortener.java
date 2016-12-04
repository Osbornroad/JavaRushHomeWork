package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

/**
 * Created by Натусик on 03.12.2016.
 */
public class Shortener {
    /**
     1.2.1.	Long getId(String string) – будет возвращать идентификатор id для заданной
     строки.

     3.4.	Реализуй метод getId, он должен:
     3.4.1.	Проверить есть ли переданное значение в хранилище, если есть – вернуть
     его ключ.
     3.4.2.	Если преданного значения нет в хранилище, то:
     3.4.2.1.	Увеличить значение lastId;
     3.4.2.2.	Добавить в хранилище новую пару ключ-значение (новое значение
     lastId и переданную строку);
     3.4.2.3.	Вернуть новое значение lastId.
     */
    public synchronized Long getId(String string)
    {
        if (storageStrategy.containsValue(string))
            return storageStrategy.getKey(string);
        else
        {
            lastId++;
            storageStrategy.put(lastId, string);
            return lastId;
        }
    }
    /**
     1.2.2.	String getString(Long id) – будет возвращать строку для заданного
     идентификатора или null, если передан неверный идентификатор.

     3.5.	Реализуй метод getString, он должен вернуть строку по заданному идентификатору
     (ключу).
     3.6.	Предусмотреть возможность вызова методов getId и getString из разных потоков.
     */
    public synchronized String getString(Long id)
    {
        return storageStrategy.getValue(id);
    }
    /**
     3.1.	Добавь в него поле Long lastId. Проинициализируй его нулем. Это поле будет
     отвечать за последнее значение идентификатора, которое было использовано при
     добавлении новой строки в хранилище.
     */
    private Long lastId = 0L;
    /**
     3.2.	Добавь поле StorageStrategy storageStrategy в котором будет храниться стратегия
     хранения данных.
     */
    private StorageStrategy storageStrategy;
    /**
     3.3.	Добавь конструктор, который принимает StorageStrategy и инициализирует
     соответствующее поле класса.
     */
    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    /**

     */
}
