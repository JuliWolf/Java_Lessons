package lesson_6;

public class Dog extends Animal {
    private static final int MAX_RUN_LENGTH = 500;
    private static final int MAX_SWIM_LENGTH = 10;

    private static int dogsCount;

    public Dog (int age, String name, String hairColor) {
        super(age, name, hairColor);

        dogsCount++;
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
        if (length > 0 && length <= MAX_SWIM_LENGTH) {
            System.out.println(this.name + " проплыл " + length + " м.");
            return;
        }

        System.out.println(this.name + " может проплыть максимум " + MAX_SWIM_LENGTH + " метров");
    }

    public static void showClassCount() {
        System.out.println("Собак создано: " + dogsCount);
    }
}
