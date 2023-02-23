package Lesson_2.Homework.sort;

import Lesson_2.Homework.notebook.NoteBook;

public class NotebookSort {
    public enum Producers {
        Lenuvo(1),
        Asos(2),
        MacNote(3),
        Eser(4),
        Xamiou(5);

        public final Integer order;

        private Producers(Integer order) {
            this.order = order;
        }
    }

    public static void sort(NoteBook[] arr) {
        int limit = arr.length;

        Integer[] temp = new Integer[arr.length];

        for (int i = 0; i < limit; i++) {
            temp[i] = arr[i].getPrice() + arr[i].getRam() - Producers.valueOf(arr[i].getProducer()).order;
        }

        for (int i = 0; i < limit - 1; i++) {
            int min = i;
            int max = i;

            for (int j = min + 1; j < limit; j++) {
                if (temp[j] < temp[min]) {
                    min = j;
                }

                if (temp[j] > temp[max]) {
                    max = j;
                }
            }

            swapNotebooks(arr, i, min);
            swapArrayElements(temp, i, min);
            if (i != max) {
                swapNotebooks(arr, limit - 1, max);
                swapArrayElements(temp, limit - 1, max);
                limit--;
            }
        }
    }

    public static void swapArrayElements (Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swapNotebooks (NoteBook[] arr, int i, int j) {
        NoteBook temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
