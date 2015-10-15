package expenseApp.java.manager;


import expenseApp.java.domain.User;
import expenseApp.java.exceptions.ValidatorException;
import expenseApp.java.exceptions.RepositoryException;
import expenseApp.java.repository.UserRepository;

public class UserManager {
    private UserRepository userRepository = new UserRepository();

    public void addNewUser(String Username, String Password) {
        User u = new User(Username, Password);
        try {
            userRepository.saveUser(u);
            System.out.println("User saved");
        }
        catch (RepositoryException e){
            System.out.println(e.getMessage());
        }
        catch (ValidatorException e) {
            System.out.println(e.getMessage());
        }
    }

}
