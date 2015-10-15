package expenseApp.java.factory;

import expenseApp.java.domain.User;

import java.util.ArrayList;

/**
 * Created by ZUZU on 07.10.2015.
 */
public class UserFactory {
    public static final String USERNAME = "poweruser";
    public static final String PASSWORD = "userpass";

    public User createUser() {
        User u = new User(USERNAME, PASSWORD);
        return u;
    }

    public User createInvalidUser() {
        User u = new User("","");
        return u;
    }

    public ArrayList<User> createUserVector() {
        ArrayList<User> users = new ArrayList<>();
        users.add(this.createUser());
        users.add(new User("user","abc12"));
        users.add(new User("user2","abc12"));
        users.add(new User("user3","abc12"));
        users.add(new User("user4","abc12"));
        return users;
    }
}
