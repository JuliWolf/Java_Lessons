package Architec.Lesson_2;

public class Rectangle extends Figure {
  private final double a;
  private final double b;

  public Rectangle(double a, double b) {
    if (!isPositive(a) || !isPositive(b)) {
      throw new RuntimeException("Not valid values");
    }

    this.a = a;
    this.b = b;
  }

  @Override
  public double calculatePerimeter() {
    return 2 * (a + b);
  }

  @Override
  public double calculateArea() {
    return a * b;
  }

  private boolean isPositive (double num) {
    return num > 0;
  }
}
