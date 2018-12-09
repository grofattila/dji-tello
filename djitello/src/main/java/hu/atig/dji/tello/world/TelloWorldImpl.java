package hu.atig.dji.tello.world;

import hu.atig.dji.tello.communication.TelloCommunication;
import hu.atig.dji.tello.communication.TelloCommunicationImpl;
import hu.atig.dji.tello.model.TelloDrone;
import hu.atig.dji.tello.model.TelloDroneImpl;
import hu.atig.dji.tello.model.TelloFlip;

public class TelloWorldImpl implements TelloWorld {

  private TelloDrone telloDrone;

  private TelloCommunication telloCommunication;

  public TelloWorldImpl() {
    telloDrone = new TelloDroneImpl();
    telloCommunication = new TelloCommunicationImpl();
  }


  @Override
  public void connect() {

  }

  @Override
  public void disconnect() {

  }

  @Override
  public void takeOff() {

  }

  @Override
  public void land() {

  }

  @Override
  public void doFlip(TelloFlip telloFlip) {

  }

  @Override
  public void setSpeed(Integer speed) {

  }

  @Override
  public void forward(Integer distance) {

  }

  @Override
  public void backward(Integer distance) {

  }

  @Override
  public void right(Integer distance) {

  }

  @Override
  public void left(Integer distance) {

  }

  @Override
  public void rotatateRight(Integer angle) {

  }

  @Override
  public void rotateLeft(Integer angle) {

  }
}
