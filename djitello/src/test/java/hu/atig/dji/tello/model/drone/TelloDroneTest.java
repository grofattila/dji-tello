package hu.atig.dji.tello.model.drone;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TelloDroneTest {

  @Test
  public void testConversions() {
    TelloDrone drone = new TelloDrone();
    drone.setAttitude("pitch:13;roll:25;yaw:31");
    drone.setAcc("agx:240.00;agy:-431.00;agz:-864.00;");

    assertEquals(drone.getAttitudePitch(), new Integer(13));
    assertEquals(drone.getAttitudeRoll(), new Integer(25));
    assertEquals(drone.getAttitudeYaw(), new Integer(31));

    assertEquals(drone.getAccX(), new Double(240.00));
    assertEquals(drone.getAccY(), new Double(-431.00));
    assertEquals(drone.getAccZ(), new Double(-864.00));
  }

}
