package budget;

import java.util.Scanner;

public class Person extends Application{
    Scanner sc = new Scanner(System.in);
    private float income = 0, balance= 0;

    public void setIncome(float income) {
        this.income = income;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getIncome() {
        return income;
    }
    public float getBalance() {
        return balance;
    }


    public void runApplication(){
        Process process = new Process();
        process.executeManager();

    }

    protected void addIncome() {
        System.out.println("Enter income:");
        float income = sc.nextInt();
        this.setIncome(this.getIncome() + income);
        this.setBalance(this.getIncome());
        System.out.println("Income was added!");
    }
    protected void showBalance() {
        System.out.println("Balance: $" + this.getBalance());
    }
    protected boolean purchasePossible(float price) {
        return (getBalance() - price) >= 0;
    }

}
