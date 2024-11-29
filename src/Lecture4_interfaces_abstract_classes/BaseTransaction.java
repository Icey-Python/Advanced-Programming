package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class BaseTransaction implements TransactionInterface{
  private final int amount;
  private final Calendar date;
  private final String transactionID;
  private int uniq;
  
    //Constructor
    public BaseTransaction(int amount, @NotNull Calendar date){
      this.amount = amount;
      this.date = (Calendar) date.clone();
      this.uniq = (int) Math.random()*10000;
    transactionID = date.toString()+uniq;
  }

  //TransactionInterface contracts
  @Override
  public double getAmount(){
    return amount;
  }

  @Override
  public Calendar getDate(){
    return (Calendar) date.clone();
  } 
  
  @Override
  public String getTransactionID(){
    return transactionID;
  }
  
  
  public void printTransactionDetails() {
        System.out.println("Transaction Details:");
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
    }

  public void apply(BankAccount ba) throws InsufficientFundsException {
    System.out.println("Cannot apply a generic transaction");
    }
}
