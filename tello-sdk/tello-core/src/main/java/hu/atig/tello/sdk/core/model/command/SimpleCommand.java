package hu.atig.tello.sdk.core.model.command;

public class SimpleCommand extends AbstractCommand {

  public SimpleCommand(String command) {
    super(command);
  }

  @Override
  public String composeCommand() {
    return null;
  }
}
