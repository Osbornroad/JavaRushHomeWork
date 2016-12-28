package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 15.1.	Создай класс SpeedTest в пакете tests.
 15.2.	Добавь в класс метод long getTimeForGettingIds(Shortener shortener, Set<String>
 strings, Set<Long> ids). Он должен возвращать время в миллисекундах необходимое
 для получения идентификаторов для всех строк из strings. Идентификаторы
 должны быть записаны в ids.
 15.3.	Добавь в класс метод long getTimeForGettingStrings(Shortener shortener,
 Set<Long> ids, Set<String> strings). Он должен возвращать время в миллисекундах
 необходимое для получения строк для всех идентификаторов из ids. Строки
 должны быть записаны в strings.
 */
public class SpeedTest
{
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids)
    {
        Date start = new Date();
        for (String string : strings)
        {
            ids.add(shortener.getId(string));
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings)
    {
        Date start = new Date();
        for (Long id : ids)
        {
            strings.add(shortener.getString(id));
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }
    /**
     15.4.	Добавь в класс SpeedTest тест testHashMapStorage(). Он должен:
     15.4.1.	Создавать два объекта типа Shortener, один на базе
     HashMapStorageStrategy, второй на базе HashBiMapStorageStrategy. Назовем
     их shortener1 и shortener2.
     15.4.2.	Генерировать с помощью Helper 10000 строк и помещать их в сет со
     строками, назовем его origStrings.
     15.4.3.	Получать время получения идентификаторов для origStrings (вызывать
     метод getTimeForGettingIds для shortener1, а затем для shortener2).
     15.4.4.	Проверять с помощью junit, что время, полученное в предыдущем пункте
     для shortener1 больше, чем для shortener2.

     15.4.5.	Получать время получения строк (вызывать метод getTimeForGettingStrings
     для shortener1 и shortener2).

     15.4.6.	Проверять с помощью junit, что время, полученное в предыдущем пункте
     для shortener1 примерно равно времени для shortener2. Используй метод
     assertEquals(float expected, float actual, float delta). В качестве delta можно
     использовать 5, этого вполне достаточно для наших экспериментов.
     */
    @Test
    public void testHashMapStorage()
    {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++)
        {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> ids1 = new HashSet<Long>();
        Set<Long> ids2 = new HashSet<Long>();

        Long timeGetId1 = getTimeForGettingIds(shortener1, origStrings, ids1);
        Long timeGetId2 = getTimeForGettingIds(shortener2, origStrings, ids2);

        Assert.assertTrue(timeGetId1 > timeGetId2);

        Long timeGetString1 = getTimeForGettingStrings(shortener1, ids1, origStrings);
        Long timeGetString2 = getTimeForGettingStrings(shortener2, ids2, origStrings);

        Assert.assertEquals(timeGetString1, timeGetString2, 5);
    }
}
