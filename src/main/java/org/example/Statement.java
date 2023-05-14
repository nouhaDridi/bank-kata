package org.example;

public class Statement {
    private final BankAccount bankAccount;

    Statement(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String toString() {
        StringBuilder statement = new StringBuilder(String.format("Account balance: %.2f\n", this.bankAccount.getBalance()));
        statement.append("Date\t\t\tOperation\tAmount\tRemaining Balance\n");
        for (Transaction transaction : this.bankAccount.getTransactions()) {
            statement.append(transaction.toString()).append("\n");
        }
        return statement.toString();
    }

    public void print() {
        System.out.print(this);
    }

}
