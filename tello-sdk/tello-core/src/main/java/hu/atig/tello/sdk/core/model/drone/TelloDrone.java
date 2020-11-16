package hu.atig.tello.sdk.core.model.drone;

import hu.atig.tello.sdk.core.communication.DroneCommandExecutor;
import hu.atig.tello.sdk.core.communication.DroneCommandExecutorImpl;
import hu.atig.tello.sdk.core.model.command.BasicCommand;
import hu.atig.tello.sdk.core.model.command.Command;
import hu.atig.tello.sdk.core.model.command.TelloCommandValues;

import java.util.logging.Logger;

/**
 * Represents the Tello onboardData.
 */
public class TelloDrone implements Drone {


    private static final Logger logger = Logger.getLogger(TelloDrone.class.getName());
    private final OnboardData onboardData;
    private final DroneCommandExecutor droneCommandExecutor;
    private TelloDrone drone;

    public TelloDrone() {
        onboardData = new TelloOnboardData();
        droneCommandExecutor = new DroneCommandExecutorImpl();
    }

    @Override
    public void connect() {
        boolean connectionSuccessful = droneCommandExecutor.connect();
        if (connectionSuccessful) {
            onboardData.setTelloConnection(ConnectionState.CONNECTED);
            logger.info("Connected!");
        }
    }

    @Override
    public void disconnect() {
        onboardData.setTelloConnection(ConnectionState.DISCONNECTED);
        droneCommandExecutor.disconnect();
        logger.info("Disconnected!");
    }

    @Override
    public void enterCommandMode() {
        Command command = new BasicCommand(TelloCommandValues.COMMAND_MODE);
        boolean executionSuccessful = droneCommandExecutor.executeCommand(command);
        if (executionSuccessful) {
            logger.info("Entering command mode successful");
        }
    }


    @Override
    public void takeOff() {
        Command command = new BasicCommand(TelloCommandValues.TAKE_OFF);
        boolean executionSuccessful = droneCommandExecutor.executeCommand(command);
        if (executionSuccessful) {
            logger.info("Taking off command was executed successfully");
        }
    }

    @Override
    public void land() {
        Command command = new BasicCommand(TelloCommandValues.LAND);
        boolean executionSuccessful = droneCommandExecutor.executeCommand(command);
        if (executionSuccessful) {
            logger.info("Landing command was executed successfully");
        }
    }

    @Override
    public void doFlip(Flip flip) {

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
    public void rotateRight(Integer angle) {

    }

    @Override
    public void rotateLeft(Integer angle) {

    }

    @Override
    public void refreshTelloOnBoarData() {
        onboardData.setSpeed(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_SPEED)));
        onboardData.setBattery(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_BATTERY)));
        onboardData.setFlyTime(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_FLY_TIME)));
        onboardData.setHeight(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_HEIGHT)));
        onboardData.setTemperature(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_TEMPERATURE)));
        onboardData.setAttitude(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_ATTITUDE_DATA)));
        onboardData.setBarometer(droneCommandExecutor
                .executeReadCommand(new BasicCommand(TelloCommandValues.CURRENT_BAROMETER)));
        //onboardData.setAcc(telloCommunication
        //    .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_ACCELERATION)));
        onboardData.setTof(
                droneCommandExecutor.executeReadCommand(new BasicCommand(TelloCommandValues.TOF)));
    }

    @Override
    public void startStream() {
        boolean executionSuccessful = droneCommandExecutor
                .executeCommand(new BasicCommand(TelloCommandValues.ENABLE_VIDEO_STREAM));
        if (executionSuccessful) {
            droneCommandExecutor.startVideoStream();
            logger.info("Stream start command was executed successfully");
        }
    }

    @Override
    public void stopStream() {
        boolean executionSuccessful = droneCommandExecutor
                .executeCommand(new BasicCommand(TelloCommandValues.DISABLE_VIDEO_STREAM));
        if (executionSuccessful) {
            droneCommandExecutor.stopVideoStream();
            logger.info("Stream end command was executed successfully");
        }
    }

    public OnboardData getTelloDroneData() {
        return onboardData;
    }

}
