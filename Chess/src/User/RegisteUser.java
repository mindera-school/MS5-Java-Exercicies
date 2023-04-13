package User;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class RegisteUser {
    public static void createUser() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Users user = new Users();
        File file = new File("src/User/File/Names");
        String filename = "src/User/File/Names";
        FileWriter fw = new FileWriter(filename, true);
        String name = "";
        String userName = "";
        String age = "";
        String password = "";
        String email = "";
        fw.write("\n");
        while (true) {
            System.out.print("User Name: ");
            userName = scanner.next();
            user.setUserName(userName);
            if (!userAvailable(userName)) {
                System.out.println("\033[0;31m" + "Username already in use!" + "\033[39m" + "\033[49m");
                continue;
            }
            fw.write(userName + " ");
            break;
        }
        System.out.print("Name: ");
        name = scanner.next();
        fw.write(name + " ");
        user.setName(name);

        System.out.print("Age: ");
        age = scanner.next();
        fw.write(age + " ");
        user.setAge(age);


        while (!Checkers.emailValid(email)) {
            System.out.print("Email: ");
            email = scanner.next();
            if (Checkers.emailValid(email)) {
                fw.write(email + " ");
                user.setEmail(email);
                break;
            }
            System.out.println("\033[0;31m" + "Your email need had @ and ." + "\033[39m" + "\033[49m");

        }

        while (!Checkers.passValid(password)) {
            System.out.print("Password: ");
            password = scanner.next();
            if (Checkers.passValid(password)) {
                fw.write(password);
                user.setPassword(password);
                break;
            }

            System.out.println("\033[0;31m" + "Your password need:" +
                    "Letters Uppercase and Lowercase " +
                    "Special charters " +
                    "Numbers " + "\033[39m" + "\033[49m");
        }
        fw.write(" "+ "0 ");
        fw.write("\n");
        DataBase.users.add(user);
        fw.close();
    }


    public static boolean userAvailable(String username) throws IOException {
        File file = new File("src/User/File/Names");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        String userName = username;
        while (br.readLine() != null) {
            line = br.readLine();
            if (line.contains(userName)) {
                return false;
            }
        }
        return true;
    }
}
