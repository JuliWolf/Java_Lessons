package Lesson_8.Homework;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private final ItemList<K, V>[] data;
    private int size;

    public HashTableImpl(int initialCapacity) {
        data = new ItemList[initialCapacity];
    }

    public HashTableImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }

        int index = hashFunc(key);
        int n = 0;

        while (data[index] != null) {
            data[index].setValue(key, value);
            return true;
        }

        data[index] = new ItemList<>(index, key, value);
        size++;

        return true;
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        return data[index].getValue(key);
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);

        Item<K, V> removed = data[index].getItem(key);
        data[index].removeValue(key);

        return removed.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%s = [%s]%n", i, data[i]));
        }
        return sb.toString();
    }
}
