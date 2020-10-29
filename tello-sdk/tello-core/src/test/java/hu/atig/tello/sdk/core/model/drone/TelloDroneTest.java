package hu.atig.tello.sdk.core.model.drone;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TelloDroneTest {

  @Test
  public void testConversions() {
    TelloDrone drone = new TelloDrone();
    drone.setAttitude("pitch:13;roll:25;yaw:31");
    drone.setAcc("agx:240.00;agy:-431.00;agz:-864.00;");

    assertEquals(drone.getAttitudePitch(), Integer.valueOf(13));
    assertEquals(drone.getAttitudeRoll(), Integer.valueOf(25));
    assertEquals(drone.getAttitudeYaw(), Integer.valueOf(31));

    assertEquals(drone.getAccX(), Double.valueOf(240.00));
    assertEquals(drone.getAccY(), Double.valueOf(-431.00));
    assertEquals(drone.getAccZ(), Double.valueOf(-864.00));
  }

}
