package hu.atig.tello.sdk.core.model.drone;

import hu.atig.tello.sdk.core.communication.DroneCommandExecutor;
import hu.atig.tello.sdk.core.communication.DroneCommandExecutorImpl;
import hu.atig.tello.sdk.core.model.command.BasicTelloCommand;
import hu.atig.tello.sdk.core.model.command.TelloCommand;
import hu.atig.tello.sdk.core.model.command.TelloCommandValues;

import java.util.logging.Logger;

/**
 * Represents the Tello onboardData.
 */
public class TelloDrone implements Drone {

    /*
     * Connection IP address.
     */
    public static final String DRONE_IP_ADDRESS = "192.168.10.1";
    /*
     * Listen IP address.
     */
    public static final String DRONE_LISTEN_IP_ADDRESS = "0.0.0.0";
    /*
     * Receive drone state udp port.
     */
    public static final Integer UDP_PORT_RECEIVE_DRONE_STATE = 8890;

    /*
     * Send command and receive response udp port.
     */
    public static final Integer UDP_PORT_SEND_COMMAND_RECEIVE_RESPONSE = 8889;
    /*
     * Send command and receive response udp port.
     */
    public static final Integer UDP_PORT_RECEIVE_DRONE_VIDEO_STREAM = 11111;
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
        TelloCommand command = new BasicTelloCommand(TelloCommandValues.COMMAND_MODE);
        boolean executionSuccessful = droneCommandExecutor.executeCommand(command);
        if (executionSuccessful) {
            logger.info("Entering command mode successful");
        }
    }


    @Override
    public void takeOff() {
        TelloCommand command = new BasicTelloCommand(TelloCommandValues.TAKE_OFF);
        boolean executionSuccessful = droneCommandExecutor.executeCommand(command);
        if (executionSuccessful) {
            logger.info("Taking off command was executed successfully");
        }
    }

    @Override
    public void land() {
        TelloCommand command = new BasicTelloCommand(TelloCommandValues.LAND);
        boolean executionSuccessful = droneCommandExecutor.executeCommand(command);
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
    public void rotateRight(Integer angle) {

    }

    @Override
    public void rotateLeft(Integer angle) {

    }

    @Override
    public void refreshTelloOnBoarData() {
        onboardData.setSpeed(droneCommandExecutor
                .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_SPEED)));
        onboardData.setBattery(droneCommandExecutor
                .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_BATTERY)));
        onboardData.setFlyTime(droneCommandExecutor
                .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_FLY_TIME)));
        onboardData.setHeight(droneCommandExecutor
                .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_HEIGHT)));
        onboardData.setTemperature(droneCommandExecutor
                .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_TEMPERATURE)));
        onboardData.setAttitude(droneCommandExecutor
                .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_ATTITUDE_DATA)));
        onboardData.setBarometer(droneCommandExecutor
                .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_BAROMETER)));
        //onboardData.setAcc(telloCommunication
        //    .executeReadCommand(new BasicTelloCommand(TelloCommandValues.CURRENT_ACCELERATION)));
        onboardData.setTof(
                droneCommandExecutor.executeReadCommand(new BasicTelloCommand(TelloCommandValues.TOF)));
    }

    @Override
    public void startStream() {
        boolean executionSuccessful = droneCommandExecutor
                .executeCommand(new BasicTelloCommand(TelloCommandValues.ENABLE_VIDEO_STREAM));
        if (executionSuccessful) {
            droneCommandExecutor.startVideoStream();
            logger.info("Stream start command was executed successfully");
        }
    }

    @Override
    public void stopStream() {
        boolean executionSuccessful = droneCommandExecutor
                .executeCommand(new BasicTelloCommand(TelloCommandValues.DISABLE_VIDEO_STREAM));
        if (executionSuccessful) {
            droneCommandExecutor.stopVideoStream();
            logger.info("Stream end command was executed successfully");
        }
    }

    public OnboardData getTelloDroneData() {
        return onboardData;
    }

}
