package Arсhitec.Lesson_1.fabric;

import Arсhitec.Lesson_1.elements.ElementBase;
import Arсhitec.Lesson_1.elements.Flash;

public class FlashGenerator extends ModelElements {
  @Override
  public ElementBase createElement() {
    return new Flash();
  }
}
