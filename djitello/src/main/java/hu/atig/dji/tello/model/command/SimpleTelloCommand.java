package hu.atig.dji.tello.model.command;

public class SimpleTelloCommand extends AbstractTelloCommand {

  public SimpleTelloCommand(String command) {
    super(command);
  }

  @Override
  public String composeCommand() {
    return null;
  }
}
