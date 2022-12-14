package task09150.command;

import task09150.CashMachine;
import task09150.ConsoleHelper;
import task09150.CurrencyManipulator;
import task09150.CurrencyManipulatorFactory;
import task09150.exception.InterruptOperationException;
import task09150.exception.NotEnoughMoneyException;

import java.util.*;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            try {
                int amount = Integer.parseInt(ConsoleHelper.readString());
                if (!cm.isAmountAvailable(amount)) {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    continue;
                }
                try {
                    Map<Integer, Integer> banknotes = cm.withdrawAmount(amount);
                    List<Integer> nominals = new ArrayList<>(banknotes.keySet());
                    Collections.sort(nominals, (o1, o2) -> o2 - o1);
                    for (Integer nominal : nominals) {
                        ConsoleHelper.writeMessage(String.format("\t%d - %d", nominal, banknotes.get(nominal)));
                    }
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
                    break;
                } catch (NotEnoughMoneyException e) {
                    ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                }
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
        }
    }
}
