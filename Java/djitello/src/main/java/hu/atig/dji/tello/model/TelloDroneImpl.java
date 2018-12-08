package hu.atig.dji.tello.model;

/**
 * Represents the Tello Drone.
 */
public class TelloDroneImpl implements TelloDrone {

  /*
   * Connection IP address.
   */
  public static final String IP_ADDRESS = "192.168.10.1";

  /*
   * Connection UDP Port.
   */
  public static final Integer UDP_PORT = 8889;
  private Integer battery;
  private Integer speed;
  private String time;
  private TelloConnection telloConnection;

  @Override
  public Integer getBattery() {
    return battery;
  }

  @Override
  public void setBattery(Integer battery) {
    this.battery = battery;
  }

  @Override
  public Integer getSpeed() {
    return speed;
  }

  @Override
  public void setSpeed(Integer speed) {
    this.speed = speed;
  }

  @Override
  public String getTime() {
    return time;
  }

  @Override
  public void setTime(String time) {
    this.time = time;
  }

  @Override
  public TelloConnection getTelloConnection() {
    return telloConnection;
  }

  @Override
  public void setTelloConnection(TelloConnection telloConnection) {
    this.telloConnection = telloConnection;
  }
}
