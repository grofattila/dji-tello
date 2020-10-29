package hu.atig.tello.sdk.core.communication;

import hu.atig.tello.sdk.core.model.drone.TelloDrone;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Logger;

public class TelloVideoStreamListenerThread extends Thread {

  private static final Logger logger = Logger
      .getLogger(TelloVideoStreamListenerThread.class.getName());

  private boolean isStreamOn;
  private DatagramSocket socket;
  private byte[] receiveData = new byte[1470];

  /**
   * Video stream IP address.
   */
  private InetAddress listenIpAddress;

  /**
   * Drones video stream UDP PORT.
   */
  private Integer udpPort;

  public TelloVideoStreamListenerThread() {
    logger.info("Initializing video thread");
    isStreamOn = true;
  }

  @Override
  public void run() {
    logger.info("Thread has started running....");
    try {
      socket = new DatagramSocket(TelloDrone.UDP_PORT_RECEIVE_DRONE_VIDEO_STREAM);
    } catch (SocketException e) {
      e.printStackTrace();
      return;
    }

    while (isStreamOn) {
      receiveData = new byte[1470];
      try {
        logger.info("Waiting for data...");
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);

        InetAddress address = receivePacket.getAddress();
        int port = receivePacket.getPort();

        logger.info("Packet received");
        logger.info("Data" + receivePacket.toString());
        //socket.send(receivePacket);

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    socket.close();

  }

  public boolean isStreamOn() {
    return isStreamOn;
  }

  public void setStreamOn(boolean streamOn) {
    isStreamOn = streamOn;
  }
}
