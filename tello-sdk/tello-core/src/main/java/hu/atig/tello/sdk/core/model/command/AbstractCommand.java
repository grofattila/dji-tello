package hu.atig.tello.sdk.core.model.command;

public abstract class AbstractCommand implements Command {

  protected String command;

  public AbstractCommand(String command) {
    this.command = command;
  }

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

}
