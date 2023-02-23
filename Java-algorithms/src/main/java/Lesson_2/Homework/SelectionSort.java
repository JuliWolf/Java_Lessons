package Lesson_2.Homework;

public class SelectionSort {
    public static void sort(Integer[] arr) {
        int limit = arr.length;

        for (int i = 0; i < limit - 1; i++) {
            int min = i;
            int max = i;

            for (int j = min + 1; j < limit; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }

                if (arr[j] > arr[max]) {
                    max = j;
                }
            }

            swapArrayElements(arr, i, min);
            if (i != max) {
                swapArrayElements(arr, limit - 1, max);
                limit--;
            }
        }
    }

    public static void swapArrayElements (Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
