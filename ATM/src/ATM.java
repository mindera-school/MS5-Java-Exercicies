import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Card card = new Card("1234");
        Scanner sc = new Scanner(System.in);
        String pass = "";

        System.out.println("INPUT PASSWORD :");
        pass = sc.next();
        System.out.println();

        try {
            card.checkCode(pass);
            doOperations(card);
        }catch (ATMException e){
            doOperations(card);
            System.out.println(e.getMessage());
        }
    }

    private static void doOperations(Card card){
        Scanner sc = new Scanner(System.in);
        String repeat = "1";
        String choice = "";
        double money = 0;
        do {
            System.out.println("Operations:");
            System.out.println("1 - Deposit");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Check Movement's");
            System.out.println("4 - Quit");
            System.out.println();
            choice = sc.next();
            switch (choice) {
                case "1" -> {
                    System.out.println("How much money do you wanna deposit?");
                    money = sc.nextDouble();
                    card.deposit(money);
                }
                case "2" -> {
                    System.out.println("How much money do you wanna withdraw?");
                    money = sc.nextDouble();
                    try {
                        card.withdraw(money);
                    } catch (ATMException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "3" -> card.checkAccountMovements();
                case "4" -> {
                    repeat = "0";
                }
            }

            if(repeat.equals("1")) {
                do {
                    System.out.println("Do you still want to do something");
                    System.out.println("1 - YES");
                    System.out.println("0 - NO");
                    repeat = sc.next();
                } while (!repeat.equals("1") && !repeat.equals("0"));
            }
        }while (repeat.equals("1"));

    }
}