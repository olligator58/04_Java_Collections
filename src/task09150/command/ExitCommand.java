package task09150.command;

import task09150.CashMachine;
import task09150.ConsoleHelper;
import task09150.exception.InterruptOperationException;

import java.util.ResourceBundle;

class ExitCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String answer = ConsoleHelper.readString();
        if (answer.toLowerCase().equals("y")) {
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        }
    }
}
