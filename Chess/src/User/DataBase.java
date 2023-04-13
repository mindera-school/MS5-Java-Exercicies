package User;

import java.util.ArrayList;

public class DataBase {
    static ArrayList<Users> users = new ArrayList<>();
    private static Users currentUser;

    public static Users getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Users currentUser) {
        DataBase.currentUser = currentUser;
    }
}
