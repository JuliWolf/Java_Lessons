package Architec.Lesson_2;

public class Circle extends Figure {
  private final double radius;

  public Circle(double radius) {
    if (radius <= 0) {
      throw new RuntimeException("Not valid value");
    }

    this.radius = radius;
  }

  @Override
  public double calculatePerimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public double calculateArea() {
    return Math.PI * (radius * radius);
  }
}
