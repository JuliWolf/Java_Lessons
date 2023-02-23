package Lesson_5.Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int ITEMS_COUNT = 10;

    public static void main(String[] args) {
        List<Item> items = generateListItems();
        displayItems(items);

        System.out.println("Final: " + new BackPack().findBestSet(items, 30));

//      Возведение в степень
        System.out.println(power(5, 3));
    }

    public static ArrayList<Item> generateListItems () {
        ArrayList<Item> arrayList = new ArrayList<>();
        for (int i = 0; i < ITEMS_COUNT; i++) {
            arrayList.add(createItem());
        }
        return arrayList;
    }

    private static void displayItems (List<Item> list) {
        for (Item i: list) {
            System.out.printf("Предмет: \t цена: %s,\t вес: %s%n", i.getPrice(),
                    i.getWeight());
        }
    }

    private static Item createItem () {
        Random random = new Random();
        int price = random.nextInt(26) * 100 + 500;
        int weight = (random.nextInt(10) + 1) * 2;
        return new Item(price, weight);
    }

    public static int power (int base, int exp) {
        if (exp == 0) {
            return 1;
        }

        return base * power(base, exp - 1);
    }

}
