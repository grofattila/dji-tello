package hu.atig.dji.tello.communication;

import hu.atig.dji.tello.model.command.TelloCommand;
import java.io.IOException;
import java.util.List;

public interface TelloCommunication {

  /**
   * Establishing connecting to the Tello drone.
   */
  boolean connect();

  /**
   * Switches the drone to command mode so commands can be executed.
   */
  void enterCommandMode();

  boolean executeCommand(final TelloCommand telloCommand) throws IOException;

  void executeCommands(final List<TelloCommand> telloCommandList);

  void disconnect();
}