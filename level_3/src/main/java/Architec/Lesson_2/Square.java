package Architec.Lesson_2;

public class Square extends Figure {
  private final double sideLength;

  public Square(double sideLength) {
    if (sideLength <= 0) {
      throw new RuntimeException("Not valid value");
    }

    this.sideLength = sideLength;
  }

  @Override
  public double calculatePerimeter() {
    return sideLength * 4;
  }

  @Override
  public double calculateArea() {
    return sideLength * sideLength;
  }
}
