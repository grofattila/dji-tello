package hu.atig.dji.tello.model;

public interface TelloDrone {

  public Integer getBattery();

  public void setBattery(Integer battery);

  public Integer getSpeed();

  public void setSpeed(Integer speed);

  public String getTime();

  public void setTime(String time);

  public TelloConnection getTelloConnection();

  public void setTelloConnection(TelloConnection telloConnection);
}
