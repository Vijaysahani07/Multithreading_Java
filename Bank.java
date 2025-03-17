/*You are building a Bank Account System where multiple users can deposit and withdraw money simultaneously. Implement thread safety using synchronization to avoid race conditions.*/


class BankAccount {

  private double balance = 0;

  // Creating constructor to initialize the Bank Balance
  
  public BankAccount(double initialBalance) {
    this.balance = initialBalance;
  }

  public synchronized void deposit(int amount) {

    System.out.println(Thread.currentThread().getName() + " deposited amount is: " + amount
        + " and Your current amount is: " + balance);

    // Implementing sleep() Thread to wait a second while depositing the Money
    try{
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    balance += amount;
    System.out.println(
        Thread.currentThread().getName() + "Your account got credited: " + amount + " and Your balance is: " + balance);
  }

  // Withdrwing the Money
  public synchronized void withdraw(int amount) {

    System.out.println(Thread.currentThread().getName() + "Withdrawan amount is: " + amount + " and Your Current Balance is: " + balance );

    try{
      Thread.sleep(1000);
    }catch(InterreuptedException e){
      e.printStackTrace();
    }
    
    if (balance >= amount) {
      balance -= amount;
      System.out.println(Thread.currentThread().getName() + " You have withdrwan: " + amount + " and Your Current amount is: " + balance);
      
    } else {
      System.out.println(Thread.currentThread.getName() + " You don't have sufficient Money, You are withdrawing: " + amount
          + "  and your Current balance is: " + balance);
    }
  }
}

public class Bank {
  public static void main(String[] args) {

    // Creating Bank Account Object
    BankAccount bankAccount = new BankAccount(5000);

    // Thread for Depositing Money
    Thread thread = new Thread(() -> {
      bankAccount.deposit(1000);
    });

    Thread thread2 = new Thread(() -> {
      bankAccount.withdraw(1000);
    });

    thread.start();
    thread2.start();
  }
}
