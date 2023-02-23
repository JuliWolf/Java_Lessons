package lesson_4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private final static int SIZE = 5;
    private final static int WINSTREAK = 4;
    private final static char DOT_EMPTY = '.';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';
    private final static char[][] MAP = new char[SIZE][SIZE];
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static Random RANDOM = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if(checkWinner(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }

            if(isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if(checkWinner(DOT_O)) {
                System.out.println("Победил ИИ");
                break;
            }
            if(isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }

        System.out.println("Игра окончена");
        SCANNER.close();
    }

    private static void initMap () {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void humanTurn () {
        int x;
        int y;

        do {
            System.out.println("Введите координаты в формате X и Y");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y));

        MAP[y][x] = DOT_X;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(SIZE);
            y = RANDOM.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер с ходил в точку " + (x + 1) + " " + (y + 1));
        MAP[y][x] = DOT_O;
    }

    private static boolean checkWinner (char symbol) {
        int lineIndex = MAP.length - 1;

        int[] top = new int[MAP.length];
        int[] left = new int[MAP.length];

        int leftDiagonal = 0;
        int rightDiagonal = 0;

        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP[i].length; j++) {
//              Check left diagonal
                if (i == j && MAP[i][j] == symbol) {
                    leftDiagonal += 1;
                }else if (i == j && MAP[i][j] != symbol) {
                    leftDiagonal = 0;
                }

                if (MAP[i][j] == symbol) {
                    top[j] += 1;
                    left[i] += 1;
                }else {
                    top[j] = 0;
                    left[i] = 0;
                }

                if (
                    top[j] == WINSTREAK ||
                    left[i] == WINSTREAK ||
                    leftDiagonal == WINSTREAK
                ) {
                    return true;
                }
            }

//           Check right diagonal
            if (MAP[i][lineIndex] == symbol) {
                rightDiagonal += 1;
            }else {
                rightDiagonal = 0;
            }

            if (rightDiagonal == WINSTREAK) {
                return true;
            }

            lineIndex--;
        }

        return false;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }

        return MAP[y][x] == DOT_EMPTY;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printMap () {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for(int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
