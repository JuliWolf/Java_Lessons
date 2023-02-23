package lesson_6;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(2, "Барсик", "рыжий");
        Cat cat2 = new Cat(1, "Рыжик", "рыжий");
        Cat cat3 = new Cat(5, "Машка", "черный");
        Cat cat4 = new Cat(3, "Тося", "серый");
        Dog dog = new Dog(4, "Бобик", "белый");

        System.out.println();

        cat.swim(10);
        dog.swim(6);
        dog.swim(11);

        System.out.println();

        cat.run(500);
        cat.run(140);
        dog.run(450);
        dog.run(550);

        System.out.println();

        Cat.showClassCount();
        Dog.showClassCount();
    }
}
