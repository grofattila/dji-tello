package hu.atig.dji.tello;

import hu.atig.dji.tello.exception.EmptyTelloCommandException;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Represents the Tello Drone.
 */
public class TelloDrone {


    private InetAddress ipAddress = null;
    private int port;
    private DatagramSocket datagramSocket;
    private boolean isImperial;



    private String sendCommand(final String command) throws IOException {
        if(command == null || command.length() == 0)
            throw new EmptyTelloCommandException();
        if(!datagramSocket.isConnected())
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
}
