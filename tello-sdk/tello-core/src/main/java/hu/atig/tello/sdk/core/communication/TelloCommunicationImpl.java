package hu.atig.tello.sdk.core.communication;

import hu.atig.tello.sdk.core.exception.TelloCommandException;
import hu.atig.tello.sdk.core.exception.TelloConnectionException;
import hu.atig.tello.sdk.core.exception.TelloException;
import hu.atig.tello.sdk.core.model.command.TelloCommand;
import hu.atig.tello.sdk.core.model.drone.TelloDrone;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Sending and receiving data from DJI Tello drone.
 */
public class TelloCommunicationImpl implements TelloCommunication {

  private static final Logger logger = Logger.getLogger(TelloCommunicationImpl.class.getName());

  /**
   * Datagram connection to the Tello drone.
   */
  private DatagramSocket ds;

  /**
   * Drone's IP address.
   */
  private InetAddress ipAddress;

  /**
   * Drones UDP PORT.
   */
  private Integer udpPort;

  /**
   * Tello video stream listener thread.
   */
  private TelloVideoStreamListenerThread videoStreamListenerThread;

  /**
   * Constructor that initialises IP address and UDP port of the drone.
   *
   * @throws TelloConnectionException In case of a bad IP address od port number.
   */
  public TelloCommunicationImpl() throws TelloConnectionException {
    try {
      this.ipAddress = InetAddress.getByName(TelloDrone.DRONE_IP_ADDRESS);
      this.udpPort = TelloDrone.UDP_PORT_SEND_COMMAND_RECEIVE_RESPONSE;
    } catch (UnknownHostException e) {
      throw new TelloConnectionException("Unknown host");
    }
  }

  @Override
  public boolean connect() throws TelloConnectionException {
    try {
      ds = new DatagramSocket(udpPort);
      ds.connect(ipAddress, udpPort);
      return ds.isConnected();
    } catch (SocketException e) {
      logger.info("Connection to the drone could not be established.");
      throw new TelloConnectionException("Could not connect");
    }
  }

  @Override
  public boolean executeCommand(final TelloCommand telloCommand) {
    if (telloCommand == null) {
      logger.info("TelloCommand was null");
      return false;
    }
    if (!ds.isConnected()) {
      logger.info("Tello connection lost");
      return false;
    }

    final String command = telloCommand.composeCommand();
    logger.info("Executing tello command: " + command);

    try {
      sendData(command);
      String response = receiveData();
      logger.info("Tello response: " + response);
    } catch (IOException e) {
      logger.info("Exception occurred during sending and receiving command");
      logger.info(e.getMessage());
      return false;
    }

    return true;
  }

  @Override
  public String executeReadCommand(TelloCommand telloCommand) throws TelloException {
    if (telloCommand == null) {
      logger.info("TelloCommand was null");
      throw new TelloCommandException("Command was empty");
    }
    if (!ds.isConnected()) {
      logger.info("Tello connection lost");
      throw new TelloConnectionException("No connection");
    }

    final String command = telloCommand.composeCommand();
    logger.info("Executing tello command: " + command);

    try {
      sendData(command);
      String response = receiveData();
      logger.info("Tello response: " + response);
      return response;
    } catch (IOException e) {
      logger.info("Exception occurred during sending and receiving command");
      logger.info(e.getMessage());
      throw new TelloConnectionException("Unexpected error during communication");
    }
  }

  @Override
  public void executeCommands(List<TelloCommand> telloCommandList) {

  }

  @Override
  public void startVideoStream() {
    logger.info("Starting video stream....");
    if (videoStreamListenerThread != null && videoStreamListenerThread.isStreamOn()) {
      videoStreamListenerThread.setStreamOn(false);
      videoStreamListenerThread = new TelloVideoStreamListenerThread();
      videoStreamListenerThread.start();
    } else {
      videoStreamListenerThread = new TelloVideoStreamListenerThread();
      videoStreamListenerThread.start();
    }
  }

  @Override
  public void stopVideoStream() {
    logger.info("Stopping video stream.");
    if (videoStreamListenerThread != null && !videoStreamListenerThread.isStreamOn()) {
      videoStreamListenerThread.setStreamOn(false);
    }
  }

  @Override
  public void disconnect() {

  }


  private void sendData(String data) throws IOException {
    byte[] sendData = data.getBytes();
    final DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress,
        udpPort);
    ds.send(sendPacket);
  }

  private String receiveData() throws IOException {
    byte[] receiveData = new byte[1024];
    final DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
    ds.receive(receivePacket);
    return trimExecutionResponse(receiveData, receivePacket);
  }

  private String trimExecutionResponse(byte[] response, DatagramPacket receivePacket) {
    response = Arrays.copyOf(response, receivePacket.getLength());
    return new String(response, StandardCharsets.UTF_8);
  }


}
