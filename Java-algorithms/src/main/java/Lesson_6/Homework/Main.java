package Lesson_6.Homework;

import Lesson_6.lesson.BinaryTree;

import java.util.Random;

public class Main {
    public static final int TREE_COUNT = 20;
    public static final int MAX_HEIGHT = 4;

    public static void main(String[] args) {
        BinaryTree<Integer>[] arr = new BinaryTree[TREE_COUNT];
        int notBalancedTrees = 0;

        for (int i = 0; i < TREE_COUNT; i++) {
            arr[i] = generateTree();

            if (arr[i].isBalanced(arr[i].getRoot()) == false) {
                notBalancedTrees++;
            }
            arr[i].display();
        }
        float percent = (float) ((notBalancedTrees*100)/TREE_COUNT);
        System.out.println("Процент несбалансированных деревьев: " + percent);

    }

    public static BinaryTree generateTree () {
        BinaryTree<Integer> tree =  new BinaryTree<>();

        while (true) {
            if (tree.getTreeHeight() == MAX_HEIGHT) {
                return tree;
            }

            int number = getRandomInt(-25, 25);
            tree.add(number);

        }
    }

    public static int getRandomInt(int min, int max){
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
