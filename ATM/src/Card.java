import java.util.ArrayList;

public class Card {
    private String password;
    private double balance;
    private ArrayList<String> movements = new ArrayList<>();

    public Card(String password){
        this.password = password;
        this.balance = 100;
    }

    public void checkCode(String password) throws ATMException{
        if(!this.password.equals(password)){
            throw new NotEnoughPermissionsException();
        }
        System.out.println("YEEEEESS");
    }

    public void deposit(double money){
        movements.add("DEPOSIT MOVEMENT :)\n\nPrevious balance: " + this.balance + "\nCurrent Balance: " + (this.balance + money) + "\n");
        this.balance += money;
    }

    public void withdraw(double money) throws ATMException{
        if(money > this.balance){
            throw new NotEnoughFundsException();
        }
        movements.add("WITHDRAW MOVEMENT :(\n\nPrevious balance: " + this.balance + "\nCurrent Balance: " + (this.balance - money) + "\n");
        this.balance -= money;
    }

    public void checkAccountMovements(){
        for(String m : movements){
            System.out.println(m);
        }
    }

    public double currentBalance(){
        return this.balance;
    }
}
