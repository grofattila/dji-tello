package hu.atig.tello.sdk.core.communication;


import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TelloVideoStreamThreadTest {

  @Test
  public void testStreamThread() {
    TelloVideoStreamListenerThread streamListenerThread = new TelloVideoStreamListenerThread();
    streamListenerThread.start();
    assertTrue(streamListenerThread.isAlive());
    streamListenerThread.setStreamOn(false);
    try {
      sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    assertFalse(streamListenerThread.isAlive());
  }


}
