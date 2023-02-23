package lesson_2;

public class HomeWorkApp {
  public static void main(String[] args) {
    System.out.println(compareSum(10, 2));

    isIntPositive(-4);

    System.out.println(isIntNegative(-8));

    printString("Hello", 4);

    System.out.println(isLepYear(2010));
  }

  public static boolean compareSum (int a, int b) {
    int sum = a + b;

    return sum >= 10 && sum <= 20;
  }

  public static void isIntPositive (int a) {
    if (a >= 0) {
      System.out.println("Число положительное");
    } else {
      System.out.println("Число отрицательное");
    }
  }

  public static boolean isIntNegative (int a) {
    return a < 0;
  }

  public static void printString(String str, int count) {
    for (int i = 0; i < count; i++) {
      System.out.println(str);
    }
  }

  public static boolean isLepYear (int year) {
    if (year % 400 == 0) {
      return true;
    } else if (year % 100 == 0) {
      return false;
    } else {
      return year % 4 == 0;
    }

  }
}
