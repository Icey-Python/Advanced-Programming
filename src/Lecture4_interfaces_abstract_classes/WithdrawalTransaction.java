package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    private double originalBalance;  // Field to store the original balance before the transaction
    private double shortfallAmount = 0; // To store the amount not withdrawn

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
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
    public void apply(BankAccount ba) throws InsufficientFundsException {
        originalBalance = ba.getBalance();

        if (originalBalance <= 0) {
            throw new InsufficientFundsException("Insufficient funds: Balance is zero or negative.");
        }

        if (originalBalance >= getAmount()) {
            ba.setBalance(originalBalance - getAmount());
            System.out.println("WithdrawalTransaction applied: Withdrawn " + getAmount());
        } else {
            throw new InsufficientFundsException("Insufficient funds: Balance is less than withdrawal amount.");
        }
    }

    // Overloaded apply() method
    public void apply(BankAccount ba, boolean allowPartial) {
        try {
            if (allowPartial && ba.getBalance() > 0 && ba.getBalance() < getAmount()) {
                shortfallAmount = getAmount() - ba.getBalance();
                System.out.println("Partial withdrawal applied: Withdrawn " + ba.getBalance() + 
                                   ", Shortfall: " + shortfallAmount);
                ba.setBalance(0); // Withdraw all available balance
            } else {
                apply(ba); // Call the original apply() method
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Error during withdrawal: " + e.getMessage());
        } finally {
            System.out.println("Transaction complete. Current balance: " + ba.getBalance());
        }
    }

    public double getShortfallAmount() {
        return shortfallAmount;
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

