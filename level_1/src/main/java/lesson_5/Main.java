package lesson_5;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иваныч", "Инженер", "ivanIvanych@mail.ru", "8-(943)-67-34", 40000, 50);
        employees[1] = new Employee("Петров Владимир Владиславович", "Сантехник", "petroVlad@mail.ru", "8-(978)-33-00", 30000, 27);
        employees[2] = new Employee("Гордыня Мария Петрововна", "Бухгалтер", "maria-gord@mail.ru", "8-(999)-56-34", 44000, 47);
        employees[3] = new Employee("Мышка Любовь Ивановна", "Повар", "myshkaPovar@mail.ru", "8-(924)-55-90", 50000, 30);
        employees[4] = new Employee("Голубь Виктор Андреевич", "Адвокат", "viktorPro@mail.ru", "8-(967)-23-23", 60000, 29);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].printEmployeeData();
                System.out.println();
            }
        }
    }
}
