package lesson_3;

import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) {
        editArray();
        createArray(100);
        multiplySmallNumbers();
        squareArray(3);
        printArray(5, createSimpleArray(2,3));
        findMinAndMax();

        int[] arr = { 1, 1, 1, 2, 1};
        System.out.println("Задача №7");
        System.out.println(checkBalance(arr));
        System.out.println();

        int[] arr2 = { 2, 3, 4, 5, 6};
        changeNumberOrder(arr2, 100);
        System.out.println();
        changeNumberOrder(arr2, -7);
    }

    public static void editArray () {
        int[] arr = { 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1 };

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }

        printArray(1, arr);
    }

    public static void createArray (int length) {
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
           arr[i] = i + 1;
        }

        printArray(2, arr);
    }

    public static void multiplySmallNumbers () {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }

        printArray(3, arr);
    }

    public static void squareArray (int length) {
        int[][] arr = new int[length][length];
        int lineIndex = length - 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
            }

            arr[i][lineIndex] = 1;
            lineIndex--;
        }

        printSquareArray(4, arr);
    }

    public static int[] createSimpleArray (int len, int initialValue) {
        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }

        return arr;
    }

    public static void findMinAndMax () {
        int min = 10;
        int max = 0;
        int[] arr = { 1, 6, 8, 16, 2, 5, 10, 4 };

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }

            if (max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.println("Задача №6");
        System.out.println("Самое большое число в массиве = " + max);
        System.out.println("Самое маленькое число в массиве = " + min);
        System.out.println();
    }

    public static boolean checkBalance (int[] arr) {
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int firstArrayEnd = i + 1;
            int rightSum = 0;
            int[] rightPart;

            if (firstArrayEnd == arr.length) {
                return false;
            }
            rightPart = Arrays.copyOfRange(arr, firstArrayEnd, arr.length);
            leftSum += arr[i];
            rightSum = Arrays.stream(rightPart).sum();

            if (leftSum == rightSum) {
                return true;
            }
        }

        return false;
    }

    public static void changeNumberOrder (int[] arr, int num) {
        if (arr == null) return;

        int length = arr.length;
        int shift = Math.abs(num);
        int[] temp = new int[length];

        if (shift == 0 || shift == length) {
            temp = arr;
        }

        if (shift > length) {
            int diff = (int) Math.floor((double) shift / length);
            if (diff > 1) {
                shift = shift - (length * diff);
            } else {
                shift = shift - length;
            }
        }

        if (num > 0) {
            System.arraycopy(arr, 0, temp, length - shift, shift);
            System.arraycopy(arr, shift, temp, 0, length - shift);
        }

        if (num < 0) {
            System.arraycopy(arr, length - shift, temp, 0, shift);
            System.arraycopy(arr, 0, temp, shift, length - shift);
        }

        printArray(8, temp);
    }

    public static void printArray (int taskNumber, int[] arr) {
        System.out.println("Задача №" + taskNumber);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        System.out.println();
    }

    public static void printSquareArray (int taskNumber, int[][] arr) {
        System.out.println("Задача №" + taskNumber);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }
}

/*

8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.*/
