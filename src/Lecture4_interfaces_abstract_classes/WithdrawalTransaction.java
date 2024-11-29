package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkDepositAmount(int amt) {
        if (amt < 0) {
            return false;
        } else {
            return true;
        }
    }

    // Method to reverse the transaction
    public boolean reverse() {
        return true;
    } // return true if reversal was successful

    // Method to print a transaction receipt or details
    public void printTransactionDetails() {
        System.out.println("Deposit Trasaction: " + this.toString());
    }

    /*
    Oportunity for assignment: implementing different form of withdrawal
     */
    @Override
    public void apply(BankAccount ba) {
        if (ba.getBalance() >= getAmount()) {
            double newBalance = ba.getBalance() - getAmount();
            ba.setBalance(newBalance);
            System.out.println("WithdrawalTransaction applied: Balance updated to " + newBalance);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }
    /*
    Assignment 1 Q3: Write the Reverse method - a method unique to the WithdrawalTransaction Class
     */
}

