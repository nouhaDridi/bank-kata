package org.example;

import org.example.operation.DepositOperation;
import org.example.operation.WithdrawOperation;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StatementTest {

    private BankAccount bankAccount;
    private Statement statement;

    @Before
    public void setup() {
        bankAccount = new BankAccount();
        statement = new Statement(bankAccount);
    }

    @Test
    public void testEmptyStatement() {
        // Arrange

        // Act
        String result = statement.toString();

        // Assert
        String expected = "Account balance: 0,00\nDate\t\t\tOperation\tAmount\tRemaining Balance\n";
        assertEquals(expected, result);
    }

    @Test
    public void testMultipleOperationsStatement() {
        // Arrange
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(LocalDateTime.of(2022, 1, 1, 10, 0), DepositOperation.class, 100.0, 100.0));
        transactions.add(new Transaction(LocalDateTime.of(2022, 1, 2, 10, 0), WithdrawOperation.class, 50.0, 50.0));
        bankAccount.setTransactions(transactions);
        bankAccount.setBalance(50.0);

        // Act
        String result = statement.toString();

        // Assert
        String expected = "Account balance: 50,00\n" +
                "Date\t\t\tOperation\tAmount\tRemaining Balance\n" +
                "2022-01-01 10:00\tDepositOperation\t100,00\t100,00\n" +
                "2022-01-02 10:00\tWithdrawOperation\t50,00\t50,00\n";
        assertEquals(expected, result);
    }

}
