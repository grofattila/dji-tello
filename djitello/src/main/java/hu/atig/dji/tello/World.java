package hu.atig.dji.tello;

import static java.lang.Thread.sleep;

import hu.atig.dji.tello.communication.TelloCommunicationImpl;
import hu.atig.dji.tello.model.TelloCommandValues;
import java.io.IOException;
import java.net.UnknownHostException;

public class World {

  /**
   * Main.
   *
   * @param args Args.
   */
  public static void main(String[] args) {

    try {
      System.out.println("Launching...");
      TelloCommunicationImpl tm = new TelloCommunicationImpl();
      tm.connect();
      tm.sendCommand(TelloCommandValues.TAKE_OFF);

      sleep(5000);

      tm.sendCommand(TelloCommandValues.LAND);


    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }
}
