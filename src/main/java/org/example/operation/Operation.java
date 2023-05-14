package org.example.operation;

import org.example.BankAccount;
import org.example.InsufficientBalanceException;
import org.example.InvalidAmountException;

public interface Operation {
    void execute(BankAccount bankAccount, Double amount) throws InvalidAmountException, InsufficientBalanceException;
}
