package hu.atig.dji.tello.communication;

import hu.atig.dji.tello.exception.TelloConnectionException;
import hu.atig.dji.tello.model.TelloDroneImpl;
import hu.atig.dji.tello.model.command.TelloCommand;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Sending and receiving data from DJI Tello drone.
 */
public class TelloCommunicationImpl implements TelloCommunication {

  private final static Logger logger = Logger.getLogger(TelloCommunicationImpl.class.getName());

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

  public TelloCommunicationImpl() throws TelloConnectionException {
    try {
      this.ipAddress = InetAddress.getByName(TelloDroneImpl.IP_ADDRESS);
      this.udpPort = TelloDroneImpl.UDP_PORT;
    } catch (UnknownHostException e) {
      throw new TelloConnectionException("Unknown host");
    }
  }

  @Override
  public boolean connect() {
    try {
      ds = new DatagramSocket(udpPort);
      ds.connect(ipAddress, udpPort);
    } catch (SocketException e) {
      logger.info("Connection to the drone could not be established.");
      throw new TelloConnectionException("Could not connect");
    }
    return true;
  }

  @Override
  public void enterCommandMode() {

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
    logger.info("Tello command: " + command);

    try {
      sendData(command);
    } catch (IOException e) {
      logger.info("Exception occurred during sending command");
      logger.info(e.getMessage());
      return false;
    }

    try {
      receiveData();
    } catch (IOException e) {
      logger.info("Exception occurred during receiving command response");
      logger.info(e.getMessage());
      return false;
    }
    return true;
  }


  @Override
  public void executeCommands(List<TelloCommand> telloCommandList) {

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
    return new String(receivePacket.getData());
  }


}
