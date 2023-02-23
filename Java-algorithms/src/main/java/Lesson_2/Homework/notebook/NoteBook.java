package Lesson_2.Homework.notebook;

public class NoteBook {
    private final int price;
    private final int ram;
    private final String producer;

    public int getPrice() {
        return price;
    }

    public int getRam () {
        return ram;
    }

    public String getProducer () {
        return producer;
    }

    public NoteBook (int price, int ram, String producer) {
        this.price = price;
        this.ram = ram;
        this.producer = producer;
    }

    public void printNotebook () {
        System.out.println("Price: " + this.price + "$, RAM: " + this.ram + "Gb, Производитель: " + this.producer);
    }
}
