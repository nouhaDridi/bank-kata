package org.example.operation;

import org.example.BankAccount;
import org.example.InvalidAmountException;
import org.example.Transaction;

import java.time.LocalDateTime;

public class DepositOperation implements Operation {
    @Override
    public void execute(BankAccount bankAccount, Double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount should be positive");
        }
        double balance = bankAccount.getBalance() + amount;
        bankAccount.setBalance(balance);
        bankAccount.getTransactions().add(new Transaction(LocalDateTime.now(), this.getClass(), amount, balance));
    }
}
