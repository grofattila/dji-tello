package hu.atig.dji.tello.world;

import hu.atig.dji.tello.communication.TelloCommunication;
import hu.atig.dji.tello.communication.TelloCommunicationImpl;
import hu.atig.dji.tello.model.command.BasicTelloCommand;
import hu.atig.dji.tello.model.command.TelloCommand;
import hu.atig.dji.tello.model.command.TelloCommandValues;
import hu.atig.dji.tello.model.drone.TelloDrone;
import hu.atig.dji.tello.model.drone.TelloFlip;
import java.util.logging.Logger;

public class TelloWorldImpl implements TelloWorld {

  private static final Logger logger = Logger.getLogger(TelloWorldImpl.class.getName());

  private TelloDrone drone;

  private TelloCommunication telloCommunication;

  public TelloWorldImpl() {
    drone = new TelloDrone();
    telloCommunication = new TelloCommunicationImpl();
  }

  @Override
  public void connect() {
    boolean connectionSuccessful = telloCommunication.connect();
    if (connectionSuccessful) {
      //drone.setTelloConnection(TelloConnection.CONNECTED);
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

  @Override
  public void refreshTelloOnBoarData() {
    TelloCommand command = null;
    String result = null;

    command = new BasicTelloCommand(TelloCommandValues.CURRENT_SPEED);
    result = telloCommunication.executeReadCommand(command);

    command = new BasicTelloCommand(TelloCommandValues.CURRENT_BATTERY);
    result = telloCommunication.executeReadCommand(command);

    command = new BasicTelloCommand(TelloCommandValues.CURRENT_FLY_TIME);
    result = telloCommunication.executeReadCommand(command);

    command = new BasicTelloCommand(TelloCommandValues.CURRENT_HEIGHT);
    result = telloCommunication.executeReadCommand(command);

    command = new BasicTelloCommand(TelloCommandValues.CURRENT_TEMPERATURE);
    result = telloCommunication.executeReadCommand(command);

    command = new BasicTelloCommand(TelloCommandValues.CURRENT_ATTITUDE_DATA);
    result = telloCommunication.executeReadCommand(command);

    command = new BasicTelloCommand(TelloCommandValues.CURRENT_BAROMETER);
    result = telloCommunication.executeReadCommand(command);

    command = new BasicTelloCommand(TelloCommandValues.CURRENT_ACCELERATION);
    result = telloCommunication.executeReadCommand(command);

    command = new BasicTelloCommand(TelloCommandValues.TOF);
    result = telloCommunication.executeReadCommand(command);
  }

}
