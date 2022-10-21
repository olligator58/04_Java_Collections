package task09150.command;

import task09150.CashMachine;
import task09150.ConsoleHelper;
import task09150.CurrencyManipulator;
import task09150.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info");

    @Override
    public void execute() {
        boolean hasMoney = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator cm : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (cm.hasMoney()) {
                ConsoleHelper.writeMessage(String.format("%s - %d", cm.getCurrencyCode(), cm.getTotalAmount()));
                hasMoney = true;
            }
        }
        if (!hasMoney) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
