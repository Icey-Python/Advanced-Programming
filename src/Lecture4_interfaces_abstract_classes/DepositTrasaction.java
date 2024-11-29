package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DepositTrasaction extends BaseTransaction {
    public DepositTrasaction(int amount, @NotNull Calendar date){
        super(amount, date);
    }
    private boolean checkDepositAmount(int amt){
        if (amt < 0){
           return false;
        }
        else{
            return  true;
        }
    }

    // Method to print a transaction receipt or details
    public void printTransactionDetails(){
        System.out.println("Deposit Trasaction: "+this.toString());
    }

@Override
    public void apply(BankAccount ba) {
        double newBalance = ba.getBalance() + getAmount();
        ba.setBalance(newBalance);
        System.out.println("DepositTransaction applied: Balance updated to " + newBalance);
    }
}
