package Arсhitec.Lesson_1;

import Arсhitec.Lesson_1.elements.Camera;
import Arсhitec.Lesson_1.elements.Flash;
import Arсhitec.Lesson_1.fabric.CameraGenerator;
import Arсhitec.Lesson_1.fabric.FlashGenerator;

public class ModelStore implements IModelChanger{
  public PoligonalModel[] models;
  public Scene[] scenes;
  public Flash[] flashes;
  public Camera[] cameras;

  public ModelStore() {
    this.flashes = new Flash[1];
    this.flashes[0] = (Flash) new FlashGenerator().createElement();

    this.cameras = new Camera[1];
    this.cameras[0] = (Camera) new CameraGenerator().createElement();
  }

  private IModelChangedObserver[] changeObservers;

  public Scene getScene (int sceneNumber) {
    return null;
  }

  @Override
  public void notifyChange(IModelChanger sender) {

  }
}
