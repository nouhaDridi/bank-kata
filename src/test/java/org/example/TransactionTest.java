package org.example;

import org.example.operation.DepositOperation;
import org.example.operation.Operation;
import org.example.operation.WithdrawOperation;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class TransactionTest {

    @Test
    public void testDepositOperation() {
        // Arrange
        LocalDateTime dateTime = LocalDateTime.of(2022, 1, 1, 10, 0);
        Class<? extends Operation> operation = DepositOperation.class;
        double amount = 100.0;
        double balance = 100.0;
        Transaction transaction = new Transaction(dateTime, operation, amount, balance);

        // Act
        String result = transaction.toString();

        // Assert
        String expected = "2022-01-01 10:00\tDepositOperation\t100,00\t100,00";
        assertEquals(expected, result);
    }

    @Test
    public void testWithdrawOperation() {
        // Arrange
        LocalDateTime dateTime = LocalDateTime.of(2022, 1, 1, 10, 0);
        Class<? extends Operation> operation = WithdrawOperation.class;
        double amount = 50.0;
        double balance = 50.0;
        Transaction transaction = new Transaction(dateTime, operation, amount, balance);

        // Act
        String result = transaction.toString();

        // Assert
        String expected = "2022-01-01 10:00\tWithdrawOperation\t50,00\t50,00";
        assertEquals(expected, result);
    }
}
