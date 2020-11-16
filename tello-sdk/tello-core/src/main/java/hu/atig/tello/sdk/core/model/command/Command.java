package hu.atig.tello.sdk.core.model.command;

public interface Command {

  /**
   * Compose the command with all the parameters neccessary.
   *
   * @return Composed command.
   */
  String composeCommand();
}