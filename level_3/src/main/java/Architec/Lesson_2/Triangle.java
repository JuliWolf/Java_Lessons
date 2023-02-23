package Architec.Lesson_2;

public class Triangle extends Figure {
  private final double a;
  private final double b;
  private final double c;

  public Triangle(double a, double b, double c) {
    if (!isPositive(a) || !isPositive(b) || !isPositive(c)) {
      throw new RuntimeException("Not valid values");
    }

    this.a = a;
    this.b = b;
    this.c = c;
  }

  @Override
  public double calculatePerimeter() {
    return a + b + c;
  }

  @Override
  public double calculateArea() {
    return calculatePerimeter() * 2 / c;
  }

  private boolean isPositive (double num) {
    return num > 0;
  }
}
