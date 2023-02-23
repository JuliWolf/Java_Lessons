package Lesson_4.Homework;

public class Test {
    public static void main(String[] args) {
        test();

    }

    private static void test() {

        DequeList<Integer> dequelist = new DequeList<>();

        dequelist.insertLeft(1);
        dequelist.insertLeft(2);
        dequelist.insertLeft(3);

        dequelist.display();

//
        System.out.println("remove first: " + dequelist.removeLeft());
        dequelist.display();

        System.out.println("remove last: " + dequelist.removeRight());
        dequelist.display();

//
        dequelist.insert(1, 1);
        dequelist.insert(3, 3);
        dequelist.insert(5, 5);
        dequelist.display();

//
        System.out.println("remove position 1: " + dequelist.remove(1));
        dequelist.display();

        System.out.println("remove position 2: " + dequelist.remove(2));

        dequelist.display();


        System.out.println("remove position 1: " + dequelist.remove(1));
        dequelist.display();
    }
}
