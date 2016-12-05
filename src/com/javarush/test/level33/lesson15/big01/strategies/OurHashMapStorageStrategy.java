package com.javarush.test.level33.lesson15.big01.strategies;

/**
 Добавь и реализуй класс OurHashMapStorageStrategy, используя класс Entry из
 предыдущей подзадачи. Класс OurHashMapStorageStrategy должен реализовывать
 интерфейс StorageStrategy.
 8.1.	Добавь в класс следующие поля:
 8.1.1.	    static final int DEFAULT_INITIAL_CAPACITY = 16;
 8.1.2.	    static final float DEFAULT_LOAD_FACTOR = 0.75f;
 8.1.3.	    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
 8.1.4.	    int size;
 8.1.5.	    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
 8.1.6.	    float loadFactor = DEFAULT_LOAD_FACTOR;
 8.2.	Реализуй в классе следующие вспомогательные методы:
 8.2.1.	int hash(Long k)
 8.2.2.	int indexFor(int hash, int length)
 8.2.3.	Entry getEntry(Long key)
 8.2.4.	void resize(int newCapacity)
 8.2.5.	void transfer(Entry[] newTable)
 8.2.6.	void addEntry(int hash, Long key, String value, int bucketIndex)
 8.2.7.	void createEntry(int hash, Long key, String value, int bucketIndex)
 8.3.	Добавь в класс публичные методы, которые требует интерфейс StorageStrategy.
 Какие-либо дополнительные поля класса не использовать. Методы, не описанные в
 задании, реализовывать не нужно. Если возникнут вопросы как реализовать какой-то
 метод или что он должен делать, то ты всегда можешь посмотреть, как работает
 похожий метод в HashMap.
 Можешь добавить в метод main класса Solution тестирование новой стратегии. Запусти
 и сравни время работы двух стратегий на одинаковом количестве элементов.
 */
public class OurHashMapStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;

    public int hash(Long k)
    {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    public int indexFor(int hash, int length)
    {
        return hash & (length - 1);
    }

    public Entry getEntry(Long key)
    {
        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    public void resize(int newCapacity)
    {
        int MAXIMUM_CAPACITY = 1 << 30;
        if (table.length == MAXIMUM_CAPACITY)
        {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }

    public void transfer(Entry[] newTable)
    {
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++)
        {
            Entry e = src[j];
            if (e != null)
            {
                src[j] = null;
                do
                {
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }
    public void addEntry(int hash, Long key, String value, int bucketIndex)
    {
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        if (size++ >= threshold)
            resize(2 * table.length);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex)
    {
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, e);
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        return false;
    }

    @Override
    public void put(Long key, String value) {

    }

    @Override
    public Long getKey(String value) {
        return null;
    }

    @Override
    public String getValue(Long key) {
        return null;
    }
}
