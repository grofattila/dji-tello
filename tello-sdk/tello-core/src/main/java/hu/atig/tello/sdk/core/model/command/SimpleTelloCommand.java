package hu.atig.tello.sdk.core.model.command;

public class SimpleTelloCommand extends AbstractTelloCommand {

  public SimpleTelloCommand(String command) {
    super(command);
  }

  @Override
  public String composeCommand() {
    return null;
  }
}
