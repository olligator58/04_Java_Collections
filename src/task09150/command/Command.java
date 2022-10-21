package task09150.command;

import task09150.exception.InterruptOperationException;

interface Command {

    void execute() throws InterruptOperationException;
}
