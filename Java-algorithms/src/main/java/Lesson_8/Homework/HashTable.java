package Lesson_8.Homework;


public interface HashTable<K, V> {

    boolean put(K key, V value);

    V get(K key);

    V remove(K key);

    int size();

    boolean isEmpty();

    void display();

    interface Entry<K, V> {
        K getKey ();
        V getValue (K key);
        Item<K, V> getItem (K key);

        void setValue(K key, V value);
    }

}
