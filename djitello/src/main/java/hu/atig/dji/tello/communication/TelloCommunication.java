package hu.atig.dji.tello.communication;

import hu.atig.dji.tello.model.command.TelloCommand;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface TelloCommunication {

  /**
   * Establishing connecting to the Tello drone.
   */
  boolean connect();

  /**
   * Executes commands on Tello drone.
   * @param telloCommand The command to be executed.
   * @return True if the executin was sucessful, false if not.
   * @throws IOException
   */
  boolean executeCommand(final TelloCommand telloCommand);

  void executeCommands(final List<TelloCommand> telloCommandList);

  void disconnect();

  /**
   * Obtains data about the Tello drone.
   *
   * @param valuesToBeObtained Valus to be obtained from the drone.
   * @return Map of the data.
   */
  Map<String, String> getTelloOnBoardData(List<String> valuesToBeObtained);
}