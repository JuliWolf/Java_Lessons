package Architec.Lesson_2;

import java.util.ArrayList;
import java.util.List;

public class GeometryFigures {
  public static void main(String[] args) {
    List<Figure> figures = new ArrayList<>();
    figures.add(new Circle(10));
    figures.add(new Square(-5));
    figures.add(new Rectangle(2,7));
    figures.add(new Triangle(5,8,4));

    figures.forEach(figure -> {
      System.out.println(figure.calculateArea());
      System.out.println(figure.calculatePerimeter());
    });
  }
}
