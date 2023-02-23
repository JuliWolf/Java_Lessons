package Lesson_8.Homework;

import java.util.ArrayList;
import java.util.List;

class ItemList<K, V> implements HashTable.Entry<K, V> {
    private int index = -1;
    private final K key;
    private List<Item<K, V>> list;

    public ItemList(int index, K key, V value) {
        this.index = index;
        this.key = key;
        this.list = new ArrayList<>();

        setValue(key, value);
    }

//    @Override
//    public int getIndex() {
//        return index;
//    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue(K key) {
        Item<K, V> item = getItem(key);

        if (item == null) {
            return null;
        }

        return item.getValue();
    }

    @Override
    public Item<K, V> getItem (K key) {
        for (int i = 0; i < size(); i++) {
            Item<K, V> item = list.get(i);

            if (item.getKey().equals(key)) {
                return item;
            }
        }

        return null;
    }


    public void setValue(K key, V value) {
        this.list.add(new Item(key, value));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ItemList{ value= {");
        for (int i = size() - 1; i >= 0 ; i--) {
            Item<K, V> item = list.get(i);
            sb.append("\n\t key= " + item.getKey() + " value= " + item.getValue());
            if (i > 0) {
                sb.append(",");
            }
        }

        return sb.append("\n}").toString();
    }

    public void removeValue (K key) {
        Item<K, V> item = getItem(key);

        list.remove(item);
    }

    public int size () {
        return this.list.size();
    }

}

