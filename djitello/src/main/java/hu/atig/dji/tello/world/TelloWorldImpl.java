package hu.atig.dji.tello.world;

import hu.atig.dji.tello.communication.TelloCommunication;
import hu.atig.dji.tello.communication.TelloCommunicationImpl;
import hu.atig.dji.tello.model.TelloConnection;
import hu.atig.dji.tello.model.TelloDrone;
import hu.atig.dji.tello.model.TelloDroneImpl;
import hu.atig.dji.tello.model.TelloFlip;
import hu.atig.dji.tello.model.command.BasicTelloCommand;
import hu.atig.dji.tello.model.command.TelloCommand;
import hu.atig.dji.tello.model.command.TelloCommandValues;
import java.util.logging.Logger;

public class TelloWorldImpl implements TelloWorld {

  private static final Logger logger = Logger.getLogger(TelloWorldImpl.class.getName());


  private TelloDrone telloDrone;

  private TelloCommunication telloCommunication;

  public TelloWorldImpl() {
    telloDrone = new TelloDroneImpl();
    telloCommunication = new TelloCommunicationImpl();
  }

  @Override
  public void connect() {
    boolean connectionSuccessful = telloCommunication.connect();
    if (connectionSuccessful) {
      telloDrone.setTelloConnection(TelloConnection.CONNECTED);
      logger.info("Connected!");
    }
  }

  @Override
  public void disconnect() {

  }

  @Override
  public void enterCommandMode() {
    TelloCommand command = new BasicTelloCommand(TelloCommandValues.COMMAND_MODE);
    boolean executionSuccessful = telloCommunication.executeCommand(command);
    if (executionSuccessful) {
      logger.info("Entering command mode successful");
    }
  }


  @Override
  public void takeOff() {
    TelloCommand command = new BasicTelloCommand(TelloCommandValues.TAKE_OFF);
    boolean executionSuccessful = telloCommunication.executeCommand(command);
    if (executionSuccessful) {
      logger.info("Taking off command was executed successfully");
    }
  }

  @Override
  public void land() {
    TelloCommand command = new BasicTelloCommand(TelloCommandValues.LAND);
    boolean executionSuccessful = telloCommunication.executeCommand(command);
    if (executionSuccessful) {
      logger.info("Landing command was executed successfully");
    }
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
