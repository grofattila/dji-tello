import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/** @author gnabit@gnamingo.de */
public class JTello {

	final public static JTello INSTANCE = new JTello();

	private InetAddress ip = null;
	private int port;
	private DatagramSocket s;
	private boolean isImperial;

	final public void connect() throws Exception {
		this.connect("192.168.10.1", 8889);
	}

	final public void connect(final String strIP, final int port) throws Exception {
		this.port = port;
		ip = InetAddress.getByName(strIP);
		s = new DatagramSocket(port);
		s.connect(ip, port);
		sendCommand("command");
		System.out.println(s.getLocalPort());
		System.out.println(s.getLocalSocketAddress());
		System.out.println(s.getLocalAddress());
		System.out.println(s.getPort());
		System.out.println(s.getRemoteSocketAddress());
		System.out.println(s.getReuseAddress());
		System.out.println(s.getReceiveBufferSize());
		System.out.println(s.getSendBufferSize());
		System.out.println(s.getTrafficClass());
	}

	final InetAddress getIP() {
		return ip;
	}

	final int getPort() {
		return port;
	}

	final DatagramSocket getSocket() {
		return s;
	}

	final public boolean isConnected() {
		if(null == s)
			return false;
		return s.isConnected();
	}

	public boolean isImperial() {
		return isImperial;
	}

	public void setImperial(boolean isImperial) {
		this.isImperial = isImperial;
	}
	
	// *** Read Commands ***

	final public String getBattery() throws IOException {
		return sendCommand("battery?");
	}

	final public String getSpeed() throws IOException {
		return sendCommand("speed?");
	}

	final public String getTime() throws IOException {
		return sendCommand("time?");
	}

	// *** Set Commands ***

	/**
	 * whaooo
	 */
	final public boolean takeOff() throws IOException {
		return isOK(sendCommand("takeoff"));
	}

	/**
	 * land
	 */
	final public boolean land() throws IOException {
		return isOK(sendCommand("land"));
	}

	/**
	 * Fly up xx | xx = (20-500 cm)
	 */
	final public boolean up(final int o) throws IOException {
		return isOK(sendCommand("up " + getDistance(o)));
	}

	/**
	 * Fly down xx | xx = (20-500 cm)
	 */
	final public boolean down(final int o) throws IOException {
		return isOK(sendCommand("down " + getDistance(o)));
	}

	/**
	 * Fly left xx | xx = (20-500 cm)
	 */
	final public boolean left(final int o) throws IOException {
		return isOK(sendCommand("left " + getDistance(o)));
	}

	/**
	 * Fly right xx | xx = (20-500 cm)
	 */
	final public boolean right(final int o) throws IOException {
		return isOK(sendCommand("right " + getDistance(o)));
	}

	/**
	 * Fly forward xx | xx = (20-500 cm)
	 */
	final public boolean forward(final int o) throws IOException {
		return isOK(sendCommand("forward " + getDistance(o)));
	}

	/**
	 * Fly backward xx | xx = (20-500 cm)
	 */
	final public boolean back(final int o) throws IOException {
		return isOK(sendCommand("back " + getDistance(o)));
	}

	/**
	 * Rotate clockwise x° | x = (1-3600°)
	 */
	final public boolean cw(final int o) throws IOException {
		return isOK(sendCommand("cw " + o));
	}

	/**
	 * Rotate counter-clockwise xx° | xx = (1-3600°)
	 */
	final public boolean ccw(final int o) throws IOException {
		return isOK(sendCommand("ccw " + o));
	}

	/**
	 * Flip x l = (left) r = (right) f = (forward) b = (back) bl = (back/left) rb = (back/right) fl = (front/left) fr = (front/right)
	 */
	final public boolean flip(final String o) throws IOException {
		return isOK(sendCommand("flip " + o));
	}

	/**
	 * Set current speed as xx | xx = (1-100 cm/s)
	 */
	final public boolean setSpeed(final int o) throws IOException {
		return isOK(sendCommand("speed " + o));
	}

	// *** internal functions ***

	final private int getDistance(final int o) {
		if(!isImperial())
			return o;
		return Math.round((float)((float)o * 2.54));
	}

	final private boolean isOK(final String strResult) {
		return null != strResult && strResult.equals("OK");
	}

	final private String sendCommand(final String strCommand) throws IOException {
		if(null == strCommand || 0 == strCommand.length())
			return "empty command";
		if(!s.isConnected())
			return "disconnected";
		byte[] receiveData = new byte[1024];
		final byte[] sendData = strCommand.getBytes();
		final DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, port);
		s.send(sendPacket);
		final DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		s.receive(receivePacket);
		final String ret = new String(receivePacket.getData());
		System.out.println("Tello " + strCommand + ": " + ret);
		return ret;
	}

	final public void close() {
		if(null != s)
			s.close();
	}
}
