package org.example.operation;

import org.example.BankAccount;
import org.example.InsufficientBalanceException;
import org.example.InvalidAmountException;
import org.example.Transaction;

import java.time.LocalDateTime;

public class WithdrawOperation implements Operation {

    @Override
    public void execute(BankAccount bankAccount, Double amount) throws InsufficientBalanceException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount should be positive");
        }
        double balance = bankAccount.getBalance();

        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        double newBalance = balance - amount;
        bankAccount.setBalance(newBalance);
        bankAccount.getTransactions().add(new Transaction(LocalDateTime.now(), this.getClass(), amount, newBalance));
    }
}
