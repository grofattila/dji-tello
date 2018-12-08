package hu.atig.dji.tello.communication;

import hu.atig.dji.tello.model.TelloCommand;
import java.util.List;

public interface TelloCommunication {

  void connect();

  void executeCommand(TelloCommand telloCommand);

  void executeCommands(List<TelloCommand> telloCommandList);

  void disconnect();
}