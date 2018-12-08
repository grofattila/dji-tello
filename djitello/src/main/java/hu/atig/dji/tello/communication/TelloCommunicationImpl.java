package hu.atig.dji.tello.communication;

import hu.atig.dji.tello.exception.TelloConnectionException;
import hu.atig.dji.tello.model.TelloCommand;
import hu.atig.dji.tello.model.TelloDroneImpl;
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
      logger.info("Connectino to the drone could not be established.");
      throw new TelloConnectionException("Could not connect, unkown host.");
    }
  }

  @Override
  public void connect() {

    try {
      ds = new DatagramSocket(udpPort);
      ds.connect(ipAddress, udpPort);

    } catch (SocketException e) {
      e.printStackTrace();
    }

    /*System.out.println(ds.getLocalPort());
    System.out.println(ds.getLocalSocketAddress());
    System.out.println(ds.getLocalAddress());
    System.out.println(ds.getPort());
    System.out.println(ds.getRemoteSocketAddress());
    System.out.println(ds.getReuseAddress());
    System.out.println(ds.getReceiveBufferSize());
    System.out.println(ds.getSendBufferSize());
    System.out.println(ds.getTrafficClass());*/
  }

  @Override
  public void executeCommand(TelloCommand telloCommand) {
    String command = null;
    if (command == null || command.length() == 0) {
      //throw new EmptyTelloCommandException();
    }
    if (!ds.isConnected()) {
      return;
    }
    byte[] receiveData = new byte[1024];
    final byte[] sendData = command.getBytes();
    final DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress,
        udpPort);
    try {
      ds.send(sendPacket);
    } catch (IOException e) {
      e.printStackTrace();
    }
    final DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
    try {
      ds.receive(receivePacket);
    } catch (IOException e) {
      e.printStackTrace();
    }
    final String ret = new String(receivePacket.getData());
    System.out.println("Tello " + command + ": " + ret);
  }


  @Override
  public void executeCommands(List<TelloCommand> telloCommandList) {

  }

  @Override
  public void disconnect() {

  }


}
