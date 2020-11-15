package hu.atig.tello.cli.client;

import hu.atig.tello.sdk.core.model.drone.Drone;
import hu.atig.tello.sdk.core.model.drone.TelloDrone;

import static java.lang.Thread.sleep;

public class TelloCliMain {

    public static void main(String[] args) {

        Drone tello = new TelloDrone();

        tello.connect();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tello.enterCommandMode();
        tello.refreshTelloOnBoarData();
    }


}
