package hu.atig.tello.sdk.core.model.command;

public interface TelloCommand {

  /**
   * Compose the command with all the parameters neccessary.
   *
   * @return Composed command.
   */
  String composeCommand();
}