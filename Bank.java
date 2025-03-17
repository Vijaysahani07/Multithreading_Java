/*You are building a Bank Account System where multiple users can deposit and withdraw money simultaneously. Implement thread safety using synchronization to avoid race conditions.*/

//We are creating A BankAccount class 
class BankAccount {

  private double balance = 0;

  // Creating constructor to initialize the Bank Balance
  public BankAccount(double initialBalance) {
    this.balance = initialBalance;
  }

  public void deposit(int amount) {
    balance += amount;
    System.out.println("Your account got credited: " + amount + " and Your balance is: " + balance);
  }

  // Withdrwing the Money
  public void withdraw(int amount) {
    if (balance >= amount) {
      balance -= amount;
      System.out.println("You have withdrwan: " + amount + " and Your Current Balance is: " + balance);
    } else {
      System.out.println("You don't have sufficient Money, You are withdrawing: " + amount
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