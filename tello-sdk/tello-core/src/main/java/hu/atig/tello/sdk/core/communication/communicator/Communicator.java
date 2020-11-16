package hu.atig.tello.sdk.core.communication.communicator;

import hu.atig.tello.sdk.core.exception.BaseException;
import hu.atig.tello.sdk.core.model.command.Command;

import java.io.IOException;
import java.util.List;

public interface Communicator {

    /**
     * Executes commands on Tello drone.
     *
     * @param command The command to be executed.
     * @throws IOException Error in communication.
     */
    void executeCommand(final Command command);

    <K, V> K executeReadCommand(final Command command) throws BaseException;

    void executeCommands(final List<Command> commandList);
}
