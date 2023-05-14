package org.example.operation;

import org.example.BankAccount;
import org.example.InvalidAmountException;
import org.example.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DepositOperationTest {

    private BankAccount bankAccount;
    private DepositOperation depositOperation;

    @Before
    public void setup() {
        bankAccount = new BankAccount();
        depositOperation = new DepositOperation();
    }

    @Test
    public void testValidDepositAmount() throws InvalidAmountException {
        // Arrange
        double initialBalance = 100.0;
        double depositAmount = 50.0;
        bankAccount.setBalance(initialBalance);

        // Act
        depositOperation.execute(bankAccount, depositAmount);

        // Assert
        double expectedBalance = initialBalance + depositAmount;
        assertEquals(expectedBalance, bankAccount.getBalance(), 0.0);
        List<Transaction> transactions = bankAccount.getTransactions();
        assertEquals(1, transactions.size());
        Transaction transaction = transactions.get(0);
        assertEquals(depositAmount, transaction.getAmount(), 0.0);
        assertEquals(DepositOperation.class, transaction.getOperation());
    }

    @Test
    public void testInvalidZeroDepositAmount() {
        // Arrange
        double initialBalance = 100.0;
        double depositAmount = 0.0;
        bankAccount.setBalance(initialBalance);

        // Act and Assert
        assertThrows(InvalidAmountException.class, () -> depositOperation.execute(bankAccount, depositAmount));
        assertEquals(initialBalance, bankAccount.getBalance(), 0.0);
        assertEquals(0, bankAccount.getTransactions().size());
    }

    @Test
    public void testInvalidNegativeDepositAmount() {
        // Arrange
        double initialBalance = 100.0;
        double depositAmount = -50.0;
        bankAccount.setBalance(initialBalance);

        // Act and Assert
        assertThrows(InvalidAmountException.class, () -> depositOperation.execute(bankAccount, depositAmount));
        assertEquals(initialBalance, bankAccount.getBalance(), 0.0);
        assertEquals(0, bankAccount.getTransactions().size());
    }
}
