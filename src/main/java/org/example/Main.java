package org.example;

import org.example.operation.DepositOperation;
import org.example.operation.Operation;
import org.example.operation.WithdrawOperation;

public class Main {
    public static void main(String[] args) throws InvalidAmountException, InsufficientBalanceException {
        BankAccount account = new BankAccount();
        Statement statement = new Statement(account);
        Operation deposit = new DepositOperation();
        Operation withdraw = new WithdrawOperation();
        deposit.execute(account,100.0);
        withdraw.execute(account,30.0);
        deposit.execute(account,50.0);
        //withdraw.execute(account,150.0);
        statement.print();
    }
}