package lesson_5;

public class Employee {
    private String FIO;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public int getAge() {
        return age;
    }

    public Employee (String FIO, String position, String email, String phoneNumber, int salary, int age) {
        this.age = age;
        this.FIO = FIO;
        this.email = email;
        this.salary = salary;
        this.position = position;
        this.phoneNumber = phoneNumber;
    }

    public void printEmployeeData () {
        System.out.println("Данные сотрудника:");
        System.out.println("ФИО: " + this.FIO);
        System.out.println("Должность: " + this.position);
        System.out.println("Email: " + this.email);
        System.out.println("Мобильный телефон: " + this.phoneNumber);
        System.out.println("Зарплата: " + this.salary);
        System.out.println("Возраст: " + this.age);
    }
}
