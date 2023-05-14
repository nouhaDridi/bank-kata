package org.example.operation;

import org.example.BankAccount;
import org.example.InsufficientBalanceException;
import org.example.InvalidAmountException;
import org.example.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class WithdrawOperationTest {
    private BankAccount bankAccount;
    private WithdrawOperation withdrawOperation;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount();
        withdrawOperation = new WithdrawOperation();
    }

    @Test
    public void testValidWithdrawAmount() throws InvalidAmountException, InsufficientBalanceException {
        // Arrange
        double initialBalance = 100.0;
        double withdrawalAmount = 50.0;
        bankAccount.setBalance(initialBalance);

        // Act
        withdrawOperation.execute(bankAccount, withdrawalAmount);

        // Assert
        double expectedBalance = initialBalance - withdrawalAmount;
        Assertions.assertEquals(expectedBalance, bankAccount.getBalance(), 0.0);
        List<Transaction> transactions = bankAccount.getTransactions();
        Assertions.assertEquals(1, transactions.size());
        Transaction transaction = transactions.get(0);
        Assertions.assertEquals(withdrawalAmount, transaction.getAmount(), 0.0);
        Assertions.assertEquals(WithdrawOperation.class, transaction.getOperation());
    }

    @Test
    public void testInvalidZeroWithdrawAmount() {
        // Arrange
        double initialBalance = 100.0;
        double withdrawalAmount = 0.0;
        bankAccount.setBalance(initialBalance);

        // Act and Assert
        Assertions.assertThrows(InvalidAmountException.class, () -> withdrawOperation.execute(bankAccount, withdrawalAmount));
    }

    @Test
    public void testInvalidNegativeWithdrawAmount() {
        // Arrange
        double initialBalance = 100.0;
        double withdrawalAmount = -50.0;
        bankAccount.setBalance(initialBalance);

        // Act and Assert
        Assertions.assertThrows(InvalidAmountException.class, () -> withdrawOperation.execute(bankAccount, withdrawalAmount));
    }

    @Test
    public void testInvalidInsufficientBalanceWithdraw() {
        // Arrange
        double initialBalance = 100.0;
        double withdrawalAmount = 150.0;
        bankAccount.setBalance(initialBalance);

        // Act and Assert
        Assertions.assertThrows(InsufficientBalanceException.class, () -> withdrawOperation.execute(bankAccount, withdrawalAmount));
    }
}