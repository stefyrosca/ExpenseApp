package expenseApp.java.domain;

/**
 * Created by ZUZU on 07.10.2015.
 */
public class User {
    private String username, password;
    private int userID;

    public User() {
        username = "newuser";
        password = "1234";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int id) { userID = id; }

    //TODO: superClass that can access the password
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    protected String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getUserID() == user.getUserID();

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userID=" + userID +
                '}';
    }

    @Override
    public int hashCode() {
        return getUserID();
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    public void UserID(int ID) {
        this.userID = ID;
    }

    //TODO: think this through

}
