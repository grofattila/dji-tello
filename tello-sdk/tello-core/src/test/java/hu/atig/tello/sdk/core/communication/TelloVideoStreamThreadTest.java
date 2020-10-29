package hu.atig.tello.sdk.core.communication;


import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
