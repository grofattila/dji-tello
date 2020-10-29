package hu.atig.tello.sdk.core.world;

import hu.atig.tello.sdk.core.communication.TelloCommunication;
import hu.atig.tello.sdk.core.communication.TelloCommunicationImpl;
import hu.atig.tello.sdk.core.model.command.BasicTelloCommand;
import hu.atig.tello.sdk.core.model.command.TelloCommand;
import hu.atig.tello.sdk.core.model.command.TelloCommandValues;
import hu.atig.tello.sdk.core.model.drone.TelloConnection;
import hu.atig.tello.sdk.core.model.drone.TelloDrone;
import hu.atig.tello.sdk.core.model.drone.TelloFlip;

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
      drone.setTelloConnection(TelloConnection.CONNECTED);
      logger.info("Connected!");
    }
  }

  @Override
  public void disconnect() {
    drone.setTelloConnection(TelloConnection.DISCONNECTED);
    telloCommunication.disconnect();
    logger.info("Disconnected!");
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
    drone.setSpeed(telloCommunication
        .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_SPEED)));
    drone.setBattery(telloCommunication
        .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_BATTERY)));
    drone.setFlyTime(telloCommunication
        .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_FLY_TIME)));
    drone.setHeight(telloCommunication
        .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_HEIGHT)));
    drone.setTemperature(telloCommunication
        .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_TEMPERATURE)));
    drone.setAttitude(telloCommunication
        .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_ATTITUDE_DATA)));
    drone.setBarometer(telloCommunication
        .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_BAROMETER)));
    //drone.setAcc(telloCommunication
    //    .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_ACCELERATION)));
    drone.setTof(
        telloCommunication.executeReadCommand(new BasicTelloCommand(TelloCommandValues.TOF)));
  }

  @Override
  public void startStream() {
    boolean executionSuccessful = telloCommunication
        .executeCommand(new BasicTelloCommand(TelloCommandValues.ENABLE_VIDEO_STREAM));
    if (executionSuccessful) {
      telloCommunication.startVideoStream();
      logger.info("Stream start command was executed successfully");
    }
  }

  @Override
  public void stopStream() {
    boolean executionSuccessful = telloCommunication
        .executeCommand(new BasicTelloCommand(TelloCommandValues.DISABLE_VIDEO_STREAM));
    if (executionSuccessful) {
      telloCommunication.stopVideoStream();
      logger.info("Stream end command was executed successfully");
    }
  }

  public String getTelloDroneData() {
    return drone.toString();
  }

}
