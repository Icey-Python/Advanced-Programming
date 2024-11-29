package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    private double originalBalance;  // Field to store the original balance before the transaction
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
         originalBalance = ba.getBalance(); // assign the current balance to original balance for tracking of transactions
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
    public boolean reverse(BankAccount ba) {
        if (ba.getBalance() == originalBalance) {
            System.out.println("Transaction already reversed or not applied.");
            return false;  // Fail case if transaction has already been reversed or was never applied
        }
        ba.setBalance(originalBalance);  // Restore the original balance
        System.out.println("WithdrawalTransaction reversed: Balance restored to " + originalBalance);
        return true;
    }
}

