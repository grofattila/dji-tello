package hu.atig.tello.sdk.core.model.drone;

public class TelloOnboardData implements OnboardData {

    /**
     * Speed of the drone.
     */
    private Double speed;

    /**
     * Battery percentage of the drone.
     */
    private Integer battery;

    /**
     * Current fly time (seconds).
     */
    private Integer flyTime;

    /**
     * Current fly height (dm).
     */
    private Integer height;

    private boolean isInCommandMode = false;

    /**
     * Current temperature of the drone.
     */
    private String temperature;
    private Integer attitudePitch;
    private Integer attitudeRoll;
    private Integer attitudeYaw;
    private Double barometer;
    private Double accX;
    private Double accY;
    private Double accZ;
    private Integer tof;

    private ConnectionState connectionState;

    public TelloOnboardData() {
        connectionState = ConnectionState.CONNECTED;
    }

    @Override
    public Double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @Override
    public void setSpeed(String speed) {
        this.speed = Double.valueOf(speed);
    }

    @Override
    public Integer getBattery() {
        return battery;
    }

    @Override
    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    @Override
    public void setBattery(String battery) {
        this.battery = Integer.valueOf(battery.trim());
    }


    @Override
    public Integer getFlyTime() {
        return flyTime;
    }

    @Override
    public void setFlyTime(String flyTime) {
        this.flyTime = Integer.valueOf(flyTime.split("s")[0]);
    }

    @Override
    public void setFlyTime(Integer flyTime) {
        this.flyTime = flyTime;
    }

    @Override
    public Integer getHeight() {
        return height;
    }

    @Override
    public void setHeight(String height) {
        this.height = Integer.valueOf(height.split("dm")[0]);
    }

    @Override
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * Sets the attitude values from the drones output.
     *
     * @param attitude Attitude in 3 dimensions.
     */
    @Override
    public void setAttitude(String attitude) {
        String[] strings = attitude.split(";");
        this.attitudePitch = Integer.valueOf(strings[0].split(":")[1]);
        this.attitudeRoll = Integer.valueOf(strings[1].split(":")[1]);
        this.attitudeYaw = Integer.valueOf(strings[2].split(":")[1]);
    }

    @Override
    public Integer getAttitudePitch() {
        return attitudePitch;
    }

    @Override
    public void setAttitudePitch(Integer attitudePitch) {
        this.attitudePitch = attitudePitch;
    }

    @Override
    public Integer getAttitudeRoll() {
        return attitudeRoll;
    }

    @Override
    public void setAttitudeRoll(Integer attitudeRoll) {
        this.attitudeRoll = attitudeRoll;
    }

    @Override
    public Integer getAttitudeYaw() {
        return attitudeYaw;
    }

    @Override
    public void setAttitudeYaw(Integer attitudeYaw) {
        this.attitudeYaw = attitudeYaw;
    }

    @Override
    public Double getBarometer() {
        return barometer;
    }

    @Override
    public void setBarometer(String baro) {
        this.barometer = Double.valueOf(baro);
    }


    @Override
    public void setBarometer(Double barometer) {
        this.barometer = barometer;
    }

    /**
     * Sets acc form the drones acc data.
     *
     * @param acc Acceleration in 3 dimensions.
     */
    @Override
    public void setAcc(String acc) {
        String[] strings = acc.split(";");
        this.accX = Double.valueOf(strings[0].split(":")[1]);
        this.accY = Double.valueOf(strings[1].split(":")[1]);
        this.accZ = Double.valueOf(strings[2].split(":")[1]);
    }

    @Override
    public Double getAccX() {
        return accX;
    }

    @Override
    public void setAccX(Double accX) {
        this.accX = accX;
    }

    @Override
    public Double getAccY() {
        return accY;
    }

    @Override
    public void setAccY(Double accY) {
        this.accY = accY;
    }

    @Override
    public Double getAccZ() {
        return accZ;
    }

    @Override
    public void setAccZ(Double accZ) {
        this.accZ = accZ;
    }

    @Override
    public String getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public ConnectionState getTelloConnection() {
        return connectionState;
    }

    @Override
    public void setTelloConnection(ConnectionState connectionState) {
        this.connectionState = connectionState;
    }

    @Override
    public Integer getTof() {
        return tof;
    }

    @Override
    public void setTof(String tof) {
        this.tof = Integer.valueOf(tof.split("mm")[0]);
    }

    @Override
    public void setTof(Integer tof) {
        this.tof = tof;
    }

    @Override
    public boolean isInCommandMode() {
        return isInCommandMode;
    }

    @Override
    public void setInCommandMode(boolean inCommandMode) {
        isInCommandMode = inCommandMode;
    }

    @Override
    public ConnectionState getConnectionState() {
        return connectionState;
    }

    @Override
    public void setConnectionState(ConnectionState connectionState) {
        this.connectionState = connectionState;
    }
}
