package hu.atig.tello.sdk.core.communication;

import hu.atig.tello.sdk.core.exception.BaseException;
import hu.atig.tello.sdk.core.exception.ConnectionException;
import hu.atig.tello.sdk.core.model.command.Command;

import java.io.IOException;
import java.util.List;

public interface DroneCommandExecutor {

  /**
   * Establishing connecting to the Tello drone.
   */
  boolean connect() throws ConnectionException;

  /**
   * Executes commands on Tello drone.
   *
   * @param command The command to be executed.
   * @return True if the executin was sucessful, false if not.
   * @throws IOException Error in communication.
   */
  boolean executeCommand(final Command command);

  String executeReadCommand(final Command command) throws BaseException;

  void executeCommands(final List<Command> commandList);

  void startVideoStream();

  void stopVideoStream();

  void disconnect();

}