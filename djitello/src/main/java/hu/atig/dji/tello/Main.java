package hu.atig.dji.tello;

import static java.lang.Thread.sleep;

import hu.atig.dji.tello.world.TelloWorld;
import hu.atig.dji.tello.world.TelloWorldImpl;

public class Main {

  /**
   * Main.
   *
   * @param args Params.
   */
  public static void main(String[] args) {
    TelloWorld telloWorld = new TelloWorldImpl();

    telloWorld.connect();
    try {
      sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    telloWorld.enterCommandMode();
    telloWorld.startStream();

    try {
      sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    telloWorld.stopStream();

  }

}
