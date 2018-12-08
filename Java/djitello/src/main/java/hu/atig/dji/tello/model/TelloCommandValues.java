package hu.atig.dji.tello.model;

/**
 * Commands for the DJI Tello drone. Source: https://github.com/grofattila/dji-tello/blob/experimental/Tello_SDK.pdf
 */
public class TelloCommandValues {

  /**
   * Enter command mode.
   */
  public static final String COMMAND = "command";

  /**
   * Auto takeoff.
   */
  public static final String TAKE_OFF = "takeoff";

  /**
   * Auto landing.
   */
  public static final String LAND = "land";

  /**
   * Fly upward xx (xx = 20 - 500 cm).
   */
  public static final String UP = "up";

  /**
   * Fly downward xx (xx = 20 - 500 cm).
   */
  public static final String DOWN = "down";

  /**
   * Fly left xx (xx = 20 - 500 cm).
   */
  public static final String LEFT = "left";

  /**
   * Fly right xx (xx = 20 - 500 cm).
   */
  public static final String RIGHT = "right";

  /**
   * Fly forward xx (xx = 20 - 500 cm).
   */
  public static final String FORWARD = "forward";

  /**
   * Fly backward xx (xx = 20 - 500 cm).
   */
  public static final String BACK = "back";

  /**
   * Rotate clockwise x° (x = 1-3600°).
   */
  public static final String CW = "cw";

  /**
   * Rotate counter-clockwise x° (x = 1-3600°).
   */
  public static final String CCW = "ccw";

  /**
   * Flip x (l = left, r = right, f = forward, b = back, bl = back/left, rb = back/right), fl =
   * front/left, fr = front/right ).
   */
  public static final String FLIP = "flip";

  /**
   * Set current speed as xx (xx = 1-100 cm/s ).
   */
  public static final String SPEED = "speed";

  /**
   * Get current speed.
   */
  public static final String CURRENT_SPEED = "Speed?";

  /**
   * Get current battery percentage.
   */
  public static final String CURRENT_BATTERY = "Battery?";

  /**
   * Get current flight time.
   */
  public static final String CURRENT_FLY_TIME = "Time?";

}
