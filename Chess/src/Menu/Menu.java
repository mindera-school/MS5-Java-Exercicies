package Menu;

import Game.Game;
import Game.Tutorial;
import User.LogIn;
import User.RegisteUser;
import User.Users;

import java.awt.desktop.SystemEventListener;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void mainMenu(){

        Scanner sc = new Scanner(System.in);
        System.out.println("\n" +
                " █████╗ ██╗  ██╗███████╗ ██████╗ ██████╗   ██████╗  █████╗ ███╗   ███╗███████╗\n" +
                "██╔══██╗██║  ██║██╔════╝██╔════╝██╔════╝  ██╔════╝ ██╔══██╗████╗ ████║██╔════╝\n" +
                "██║  ╚═╝███████║█████╗  ╚█████╗ ╚█████╗   ██║  ██╗ ███████║██╔████╔██║█████╗  \n" +
                "██║  ██╗██╔══██║██╔══╝   ╚═══██╗ ╚═══██╗  ██║  ╚██╗██╔══██║██║╚██╔╝██║██╔══╝  \n" +
                "╚█████╔╝██║  ██║███████╗██████╔╝██████╔╝  ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗\n" +
                " ╚════╝ ╚═╝  ╚═╝╚══════╝╚═════╝ ╚═════╝    ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝");
        System.out.println("----------------------------");
        System.out.println(" ① \uD835\uDDE7\uD835\uDE02\uD835\uDE01\uD835\uDDFC\uD835\uDDFF\uD835\uDDF6\uD835\uDDEE\uD835\uDDF9");
        System.out.println(" ② \uD835\uDDD6\uD835\uDDFF\uD835\uDDF2\uD835\uDDEE\uD835\uDE01\uD835\uDDF2 \uD835\uDE02\uD835\uDE00\uD835\uDDF2\uD835\uDDFF");
        System.out.println(" ③ \uD835\uDDDA\uD835\uDDEE\uD835\uDDFA\uD835\uDDF2");
        System.out.println(" ④ \uD835\uDDE6\uD835\uDDF2\uD835\uDDF2 \uD835\uDDFD\uD835\uDDF9\uD835\uDDEE\uD835\uDE06\uD835\uDDF2\uD835\uDDFF \uD835\uDDFD\uD835\uDDFF\uD835\uDDFC\uD835\uDDF3\uD835\uDDF6\uD835\uDDF9\uD835\uDDF2");
        System.out.println("----------------------------");

        int option = sc.nextInt();
        switch (option) {
            case 1:
                Tutorial.showTutorial();
                mainMenu();
                break;
            case 2:
                try {
                    RegisteUser.createUser();
                } catch (Exception e) {
                    System.out.println("\033[0;31m" + "Unable to register" + "\033[39m" + "\033[49m");
                }
                mainMenu();
                break;
            case 3:
                    Game.gameScript();

                mainMenu();
                break;
            case 4:
                try {
                    Users.printAccount();
                } catch (Exception e) {
                    System.out.println("\033[0;31m" + "Account doesn't exist" + "\033[39m" + "\033[49m");
                }
            default:
                mainMenu();
        }
    }
}
