import java.util.Scanner;

public class Main {
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    public static Boolean valid(int numb, String name){
        if (name.length() < numb){
            System.out.println(ANSI_RED_BACKGROUND + "Nao e possivel efetuar a operacao" + "\033[39m" + "\033[49m");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String name = "";
        int numChar = 0;
        String change = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome Pretendido");
        name = scanner.nextLine();

        do{
            System.out.println("Numero de letras no final");
            numChar = scanner.nextInt();
        }while(valid(numChar,name));

        change = name.substring(name.length() - numChar);
        System.out.println(ANSI_BLUE_BACKGROUND + (change.concat(name)) + "\033[39m" + "\033[49m");

    }
}