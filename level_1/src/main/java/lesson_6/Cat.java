package lesson_6;

public class Cat extends Animal {
    private static final int MAX_RUN_LENGTH = 200;

    private static int catsCount;

    public Cat (int age, String name, String hairColor) {
        super(age, name, hairColor);

        catsCount++;
    }

    @Override
    public void run(int length) {
        if (length > 0 && length <= MAX_RUN_LENGTH) {
            System.out.println(this.name + " пробежал " + length + " м.");
            return;
        }

        System.out.println(this.name + " может пробежать максимум " + MAX_RUN_LENGTH + " метров");
    }

    @Override
    public void swim(int length) {
        System.out.println(this.name + " не умеет плавать.");
    }

    public static void showClassCount() {
        System.out.println("Кошек создано: " + catsCount);
    }
}
