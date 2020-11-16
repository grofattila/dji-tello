package hu.atig.tello.sdk.core.communication.connection;

import hu.atig.tello.sdk.core.exception.ConnectionException;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Logger;

public class SocketDroneConnection implements DroneConnection {

    private static final Logger LOGGER = Logger.getLogger(SocketDroneConnection.class.getName());
    /**
     * Drone's IP address.
     */
    private final InetAddress ipAddress;
    /**
     * Drones UDP PORT.
     */
    private final Integer udpPort;
    /**
     * Datagram connection to the Tello drone.
     */
    private DatagramSocket ds;

    private SocketDroneConnection(InetAddress ipAddress, Integer udpPort) {
        this.ipAddress = ipAddress;
        this.udpPort = udpPort;
    }

    @Override
    public void connect() throws ConnectionException {
        try {
            ds = new DatagramSocket(udpPort);
            ds.connect(ipAddress, udpPort);
            if (!ds.isConnected()) {
                LOGGER.severe("Connection to the drone could not be established.");
                LOGGER.severe("Reason unknown.");
            }
        } catch (SocketException e) {
            LOGGER.severe("Connection to the drone could not be established.");
            throw new ConnectionException("Could not connect");
        }
    }

    public DatagramSocket getDs() {
        return ds;
    }

}
