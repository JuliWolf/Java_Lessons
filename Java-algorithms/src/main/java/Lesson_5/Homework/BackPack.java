package Lesson_5.Homework;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BackPack {
    private Set<Item> resultSet = new LinkedHashSet<>();
    private List<Item> list;
    private int maxWeight;
    private int maxPrice;


    public Set<Item> findBestSet (List<Item> items, int weight) {
        resultSet.clear();
        list = items;
        maxWeight = weight;
        find(list.size());

        return resultSet;
    }

    private void find(int length) {
        if (length == 1) {
            return;
        }

        if (compare(0)) {
            return;
        }

        for (int i = 0; i < length; i++) {
            find(length - 1);

            compare(i);

            rotate(length);
        }
    }

    private boolean compare (int i) {
        int weightSum = 0;
        int totalPrice = 0;
        Set<Item> tempSet = new LinkedHashSet<>();

        for (int j = 0; j < list.size() - i; j++) {
            Item item = list.get(j);
            weightSum += item.getWeight();
            totalPrice += item.getPrice();
            tempSet.add(item);
        }

        if (weightSum > maxWeight) {
            return false;
        }

        if (totalPrice < maxPrice) {
            return false;
        }

        maxPrice = totalPrice;
        resultSet = tempSet;

        return true;
    }

    private void rotate(int length) {
        int first = list.size() - length;

        Item temp = list.get(first);
        for (int i = first + 1; i < list.size(); i++) {
            list.set(i - 1, list.get(i));
        }
        list.set(list.size() - 1, temp);
    }
}
