package hu.atig.tello.sdk.core.model.drone;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TelloDroneTest {

  @Test
  public void testConversions() {
    TelloDrone drone = new TelloDrone();

    drone.getTelloDroneData().setAttitude("pitch:13;roll:25;yaw:31");
    drone.getTelloDroneData().setAcc("agx:240.00;agy:-431.00;agz:-864.00;");

    assertEquals(drone.getTelloDroneData().getAttitudePitch(), Integer.valueOf(13));
    assertEquals(drone.getTelloDroneData().getAttitudeRoll(), Integer.valueOf(25));
    assertEquals(drone.getTelloDroneData().getAttitudeYaw(), Integer.valueOf(31));

    assertEquals(drone.getTelloDroneData().getAccX(), Double.valueOf(240.00));
    assertEquals(drone.getTelloDroneData().getAccY(), Double.valueOf(-431.00));
    assertEquals(drone.getTelloDroneData().getAccZ(), Double.valueOf(-864.00));
  }

}
