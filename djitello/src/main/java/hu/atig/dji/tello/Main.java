package hu.atig.dji.tello;

import hu.atig.dji.tello.world.TelloWorld;
import hu.atig.dji.tello.world.TelloWorldImpl;

public class Main {

  public static void main(String[] args) {
    TelloWorld telloWorld = new TelloWorldImpl();

    telloWorld.connect();
    telloWorld.enterCommandMode();
    telloWorld.refreshTelloOnBoarData();

  }

}
