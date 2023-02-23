package Lesson_2.Homework;

import java.util.Random;

import Lesson_2.Homework.notebook.NoteBook;

public class NotebookArray {
    public static boolean isShuffle = false;

    private static final Random random = new Random();
    public static int[] ram = { 4, 8, 12, 16, 20, 24 };
    public static String[] producers = { "Lenuvo", "Asos", "MacNote", "Eser", "Xamiou" };

    public static NoteBook[] getArray(int length, int gap) {
        NoteBook[] arr = new NoteBook[length];

        for (int i = 0; i < length; i++) {
            int price = 50;
            if (i != 0) {
                price = (random.nextInt(40) + 1) * gap;
            }

            int memory = ram[randomInt(0, ram.length - 1)];
            String producer = producers[randomInt(0, producers.length - 1)];

            arr[i] = new NoteBook(price, memory, producer );
        }

        if (isShuffle) {
            shuffleArray(arr);
        }
        return arr;
    }

    public static void shuffleArray(NoteBook[] arr) {
        if(!isShuffle) {
            return;
        }
        int n = arr.length;
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(arr, i, change);
        }
    }

    private static void swap(NoteBook[] a, int i, int change) {
        NoteBook temp = a[i];
        a[i] = a[change];
        a[change] = temp;
    }

    public static int randomInt(int min, int max) {
        return (int)(Math.random() * (max + 1 - min) + min);
    }
}
