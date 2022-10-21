package task09150.command;

import task09150.CashMachine;
import task09150.ConsoleHelper;
import task09150.CurrencyManipulator;
import task09150.CurrencyManipulatorFactory;
import task09150.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] twoDigits = ConsoleHelper.getValidTwoDigits(currencyCode);
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        try {
            cm.addAmount(Integer.parseInt(twoDigits[0]), Integer.parseInt(twoDigits[1]));
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.parseInt(twoDigits[0]) * Integer.parseInt(twoDigits[1]), currencyCode));
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
