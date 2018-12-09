package hu.atig.dji.tello.world;

import hu.atig.dji.tello.model.TelloFlip;

public interface TelloWorld {

  /**
   * Establsihing connection to the Tello Drone.
   */
  void connect();

  /**
   * Disconnecting from the drone. If the drone is not landed yet, it will start an automatic
   * landing.
   */
  void disconnect();

  /**
   * Taking off from the ground.
   */
  void takeOff();

  /**
   * Landing on the ground.
   */
  void land();

  /**
   * Doing a flip in the chosen direction.
   *
   * @param telloFlip Type of the flip.
   */
  void doFlip(TelloFlip telloFlip);

  /**
   * Settign the drone's speed.
   *
   * @param speed Chosen speed.
   */
  void setSpeed(Integer speed);

  void forward(Integer distance);

  void backward(Integer distance);

  void right(Integer distance);

  void left(Integer distance);

  void rotatateRight(Integer angle);

  void rotateLeft(Integer angle);



}
