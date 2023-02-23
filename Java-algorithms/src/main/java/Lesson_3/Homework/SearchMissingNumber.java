package Lesson_3.Homework;

public class SearchMissingNumber {
    public static int search(Integer[] arr) {
        return search(arr, 0, arr.length);
    }

    public static int search(Integer[] arr, int start, int end) {
        int base;
        int i = 0;
        int expectedNumber;

        while (end >= start) {
            i++;
            base = (start + end) / 2;
            expectedNumber = base + 1;
            System.out.println("Base = " + base);

            if(start == end && (base == arr.length || arr[base] != expectedNumber)) {
                System.out.println("НАШЛИ! Кол-во итераций: " + i);
                System.out.println("НАШЛИ! Найденное число: " + expectedNumber);
                return expectedNumber;
            } else if (arr[base] == expectedNumber) {
                start = base + 1;
            } else if (arr[base] > expectedNumber) {
                end = base;
            }
        }
        return -1;
    }
}
