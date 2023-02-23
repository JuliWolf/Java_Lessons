package Lesson_2.lesson;

import Lesson_2.lesson.search.*;
import Lesson_2.lesson.sort.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArray.isRepeat = false;
        MyArray.isShuffle = true;
        final int SIZE = 500000;
        Integer[] arr = MyArray.getArray(SIZE, 2);

//        System.out.println(Arrays.toString(arr));

        SpeedTest.startTime();

        //sort при 50000
//        BubbleSort.sort(arr); //13411 // 4
//        CocktailSort.sort(arr); //13497
//        SelectionSort.sort(arr); //3360
//        InsertionSort.sort(arr); //2286
//        CombSort.sort(arr); // 47
//        Arrays.sort(arr); //47
        PigeonholeSort.sort(arr); //12

        SpeedTest.endTime();

        System.out.println(Arrays.toString(arr));

        System.out.println(BinarySearch.search(arr, 1));
        System.out.println(ExponentialSearch.search(arr, 1));
        System.out.println(InterpolationSearch.search(arr, 1));

    }
}
