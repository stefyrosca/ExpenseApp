package expenseApp.java.repository;

import expenseApp.java.exceptions.RepositoryException;
import expenseApp.java.domain.User;
import expenseApp.java.domain.UserValidator;
import expenseApp.java.exceptions.ValidatorException;
import utils.StringUtils;

import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();
    private UserValidator userValidator = new UserValidator();
    int NextID = 1;

    public void saveUser(User u) throws RepositoryException, ValidatorException {
        if (findUserByUsername(u.getUsername()) != null) {
            throw new RepositoryException("A user already exists with this username");
        }
        try {
            if (userValidator.validate(u)) {
                u.setUserID(NextID++);
                users.add(u);
                return;
            }
        }
        catch (ValidatorException e) {
            throw new ValidatorException(e.getMessage());
        }

    }

    public User findUserById(int ID) {
        if (ID<1) {
            return  null;
        }
        for (User user: users) {
            if (user.getUserID() == ID) {
                return user;
            }
        }
        return null;
    }

    public User findUserByUsername(String username) {
        if (!StringUtils.isValid(username)) {
            return null;
        }
        for (User user: users) {
            if (user.getUsername()==username) {
                return user;
            }
        }
        return null;
    }

    public int getSize() {
        return users.size();
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
