package hu.atig.tello.sdk.core.communication;

import hu.atig.tello.sdk.core.exception.TelloConnectionException;
import hu.atig.tello.sdk.core.exception.TelloException;
import hu.atig.tello.sdk.core.model.command.TelloCommand;

import java.io.IOException;
import java.util.List;

public interface TelloCommunication {

  /**
   * Establishing connecting to the Tello drone.
   */
  boolean connect() throws TelloConnectionException;

  /**
   * Executes commands on Tello drone.
   * @param telloCommand The command to be executed.
   * @return True if the executin was sucessful, false if not.
   * @throws IOException Error in communication.
   */
  boolean executeCommand(final TelloCommand telloCommand);

  String executeReadCommand(final TelloCommand telloCommand) throws TelloException;

  void executeCommands(final List<TelloCommand> telloCommandList);

  void startVideoStream();

  void stopVideoStream();

  void disconnect();

}