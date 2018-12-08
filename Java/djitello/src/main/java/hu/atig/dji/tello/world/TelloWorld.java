package hu.atig.dji.tello.world;

import hu.atig.dji.tello.model.TelloFlip;

public interface TelloWorld {

  void connect();

  void disconnect();

  void takeOff();

  void land();

  void doFlip(TelloFlip telloFlip);

  void setSpeed(Integer speed);

  void forward();

  void backward();

  void right();

  void left();

  void rotatateRight();

  void rotateLeft();

}
