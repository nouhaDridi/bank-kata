package org.example;

import org.example.operation.Operation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDateTime date;
    private Class<? extends Operation> operation;
    private double amount;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Class<? extends Operation> getOperation() {
        return operation;
    }

    public void setOperation(Class<? extends Operation> operation) {
        this.operation = operation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;

    public Transaction(LocalDateTime date, Class<? extends Operation> operation, double amount, double balance) {
        this.date = date;
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return String.format("%s\t%s\t%.2f\t%.2f", date.format(formatter), operation.getSimpleName(), amount, balance);
    }
}