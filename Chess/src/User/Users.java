package User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

public class Users {

    private String name;
    private String userName;
    private String age;
    private String email;
    private String password;

    private String points;
    private boolean logIn;

    private String rank;

    public Users(String userName, String name, String age, String email, String password, String points, String rank) {
        this.name = name;
        this.userName = userName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.points = points;
        this.rank = rank;
    }

    public Users() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public boolean isLogIn() {
        return logIn;
    }

    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }

    public String toString() {
        return getName() + getUserName() + getAge() + getEmail() + getPassword();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public static void printAccount() throws Exception {
        Scanner scanner = new Scanner(System.in);

        File file = new File("src/User/File/Names");
        String filename = "src/User/File/Names";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        System.out.print("Username: ");
        String userName = scanner.next();
        while (br.readLine() != null) {
            line = br.readLine();
            if (line.contains(userName)) {
                break;
            }
        }
        String[] arrOfStr = line.split("\s");
        System.out.println("\033[0;36m" + "👨‍🦲Name: " + "\033[39m" + "\033[49m" + arrOfStr[1]);
        System.out.println("\033[0;36m" + "🤓Username: " + "\033[39m" + "\033[49m" + arrOfStr[0]);
        System.out.println("\033[0;36m" + "👶Age: " + "\033[39m" + "\033[49m" + arrOfStr[2]);
        System.out.println("＠" + "\033[0;36m" + "Email: " + "\033[39m" + "\033[49m" + arrOfStr[3]);
        System.out.println("\033[0;36m" + "💎Points: " + "\033[39m" + "\033[49m" + arrOfStr[5]);
        System.out.println("\033[0;36m" + "🤴Rank: " + "\033[39m" + "\033[49m" + calculateRank(Integer.parseInt(arrOfStr[5])));
        System.out.println();

        URL url = new URL("mailto:"+arrOfStr[3]);
        System.out.println("Contact "+arrOfStr[1]+" on "+ url);
    }

    public static String calculateRank(int points) {
        if (points > 13000) {
            return "🗡";
        }
        if (points > 8500) {
            return "🪓";
        }
        if (points > 4500) {
            return "🔨";
        }
        if (points > 2500) {
            return "🎣";
        }
        if (points > 1000) {
            return "🧹";
        }
        if (points >= 0) {
            return "Unranked";
        }
        return null;
    }
}
