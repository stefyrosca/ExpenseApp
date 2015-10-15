package expenseApp.java.domain;

/**
 * Created by ZUZU on 12.10.2015.
 */
public class Admin extends User {

    public void changePassword(User user, String password) {
        user.setPassword(password);
    }

}
