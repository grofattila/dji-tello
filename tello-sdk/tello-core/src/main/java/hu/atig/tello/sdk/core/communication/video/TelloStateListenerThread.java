package hu.atig.tello.sdk.core.communication.video;

import hu.atig.tello.sdk.core.model.drone.TelloConnectionConfiguration;

import java.io.IOException;
import java.net.*;
import java.util.logging.Logger;

public class TelloStateListenerThread extends Thread {

  private static final Logger logger = Logger
      .getLogger(TelloStateListenerThread.class.getName());

  private boolean isStreamOn;
  private DatagramSocket ds;
  private byte[] receiveData = new byte[1024];
  private final byte[] sendData = new byte[1024];

  /**
   * Video stream IP address.
   */
  private InetAddress listenIpAddress;

  /**
   * Drones video stream UDP PORT.
   */
  private Integer udpPort;

  /**
   * TODO.
   */
  public TelloStateListenerThread() {
    logger.info("Initializing video thread");
    isStreamOn = true;
    try {
      this.listenIpAddress = InetAddress.getByName(TelloConnectionConfiguration.DRONE_LISTEN_IP_ADDRESS);
      this.udpPort = TelloConnectionConfiguration.COMMAND_PORT;
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    logger.info("Thread has started running....");
    try {
      ds = new DatagramSocket(udpPort);
      ds.connect(listenIpAddress, udpPort);
    } catch (SocketException e) {
      e.printStackTrace();
      return;
    }

    while (isStreamOn) {
      receiveData = new byte[345600];
      try {
        logger.info("Waiting for data...");
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        ds.receive(receivePacket);
        logger.info("Packet received");
        logger.info("Data" + receivePacket.toString());

      } catch (IOException e) {
        e.printStackTrace();
      }
    }


  }

  public boolean isStreamOn() {
    return isStreamOn;
  }

  public void stopThread(boolean streamOn) {
    isStreamOn = false;
  }
}
