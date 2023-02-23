package lesson_6;

public abstract class Animal {
    protected int age;
    protected String name;
    protected String hairColor;

    private static int animalsCount;

    public Animal (int age, String name, String hairColor) {
        this.age = age;
        this.name = name;
        this.hairColor = hairColor;

        animalsCount++;
        System.out.println("Создано животных: " + animalsCount);
    }

    public abstract void run (int length);

    public abstract void swim (int length);

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getHairColor() {
        return hairColor;
    }
}
