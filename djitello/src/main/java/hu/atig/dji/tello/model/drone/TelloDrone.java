package hu.atig.dji.tello.model.drone;

/**
 * Represents the Tello Drone.
 */
public class TelloDrone implements Drone {

  /*
   * Connection IP address.
   */
  public static final String IP_ADDRESS = "192.168.10.1";

  /*
   * Connection UDP Port.
   */
  public static final Integer UDP_PORT = 8889;

  private Integer speed;
  private Integer battery;
  private String flyTime;
  private Integer height;
  private Integer temperature;
  private Integer attitudePitch;
  private Integer attitudeRoll;
  private Integer attitudeYaw;
  private Double barometer;
  private Double accX;
  private Double accY;
  private Double accZ;
  private Integer TOF;

  private TelloConnection telloConnection;
  private TelloMode telloMode;

  public TelloDrone() {
    telloConnection = TelloConnection.CONNECTED;
    telloMode = TelloMode.NORMAL;
  }

  public Integer getSpeed() {
    return speed;
  }

  public void setSpeed(Integer speed) {
    this.speed = speed;
  }

  public Integer getBattery() {
    return battery;
  }

  public void setBattery(Integer battery) {
    this.battery = battery;
  }

  public String getFlyTime() {
    return flyTime;
  }

  public void setFlyTime(String flyTime) {
    this.flyTime = flyTime;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getTemperature() {
    return temperature;
  }

  public void setTemperature(Integer temperature) {
    this.temperature = temperature;
  }

  public Integer getAttitudePitch() {
    return attitudePitch;
  }

  public void setAttitudePitch(Integer attitudePitch) {
    this.attitudePitch = attitudePitch;
  }

  public Integer getAttitudeRoll() {
    return attitudeRoll;
  }

  public void setAttitudeRoll(Integer attitudeRoll) {
    this.attitudeRoll = attitudeRoll;
  }

  public Integer getAttitudeYaw() {
    return attitudeYaw;
  }

  public void setAttitudeYaw(Integer attitudeYaw) {
    this.attitudeYaw = attitudeYaw;
  }

  public Double getBarometer() {
    return barometer;
  }

  public void setBarometer(Double barometer) {
    this.barometer = barometer;
  }

  public Double getAccX() {
    return accX;
  }

  public void setAccX(Double accX) {
    this.accX = accX;
  }

  public Double getAccY() {
    return accY;
  }

  public void setAccY(Double accY) {
    this.accY = accY;
  }

  public Double getAccZ() {
    return accZ;
  }

  public void setAccZ(Double accZ) {
    this.accZ = accZ;
  }

  public Integer getTOF() {
    return TOF;
  }

  public void setTOF(Integer TOF) {
    this.TOF = TOF;
  }

  public TelloConnection getTelloConnection() {
    return telloConnection;
  }

  public void setTelloConnection(TelloConnection telloConnection) {
    this.telloConnection = telloConnection;
  }

  public TelloMode getTelloMode() {
    return telloMode;
  }

  public void setTelloMode(TelloMode telloMode) {
    this.telloMode = telloMode;
  }
}
