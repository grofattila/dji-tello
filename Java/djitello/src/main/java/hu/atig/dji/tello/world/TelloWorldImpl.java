package hu.atig.dji.tello.world;

import hu.atig.dji.tello.communication.TelloCommunication;
import hu.atig.dji.tello.communication.TelloCommunicationImpl;
import hu.atig.dji.tello.model.TelloDrone;
import hu.atig.dji.tello.model.TelloDroneImpl;

public class TelloWorldImpl {

  private TelloDrone telloDrone;

  private TelloCommunication telloCommunication;

  public TelloWorldImpl() {
    telloDrone = new TelloDroneImpl();
    telloCommunication = new TelloCommunicationImpl();
  }
}
