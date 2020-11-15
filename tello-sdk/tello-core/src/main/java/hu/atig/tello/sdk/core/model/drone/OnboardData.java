package hu.atig.tello.sdk.core.model.drone;

public interface OnboardData {
    Double getSpeed();

    void setSpeed(Double speed);

    void setSpeed(String speed);

    Integer getBattery();

    void setBattery(Integer battery);

    void setBattery(String battery);

    Integer getFlyTime();

    void setFlyTime(String flyTime);

    void setFlyTime(Integer flyTime);

    Integer getHeight();

    void setHeight(String height);

    void setHeight(Integer height);

    void setAttitude(String attitude);

    Integer getAttitudePitch();

    void setAttitudePitch(Integer attitudePitch);

    Integer getAttitudeRoll();

    void setAttitudeRoll(Integer attitudeRoll);

    Integer getAttitudeYaw();

    void setAttitudeYaw(Integer attitudeYaw);

    Double getBarometer();

    void setBarometer(String baro);

    void setBarometer(Double barometer);

    void setAcc(String acc);

    Double getAccX();

    void setAccX(Double accX);

    Double getAccY();

    void setAccY(Double accY);

    Double getAccZ();

    void setAccZ(Double accZ);

    String getTemperature();

    void setTemperature(String temperature);

    ConnectionState getTelloConnection();

    void setTelloConnection(ConnectionState connectionState);

    Integer getTof();

    void setTof(String tof);

    void setTof(Integer tof);

    boolean isInCommandMode();

    void setInCommandMode(boolean inCommandMode);

    ConnectionState getConnectionState();

    void setConnectionState(ConnectionState connectionState);
}
