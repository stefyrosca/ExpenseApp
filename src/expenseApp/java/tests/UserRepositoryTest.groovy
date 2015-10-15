package expenseApp.java.tests

import expenseApp.java.domain.User
import expenseApp.java.factory.UserFactory
import expenseApp.java.repository.UserRepository

class UserRepositoryTest extends GroovyTestCase {

    User user;
    User invalidUser;
    ArrayList<User> users;
    UserRepository userRepository;

    void setUp() {
        userRepository = new UserRepository();
        UserFactory factory = new UserFactory();
        user = factory.createUser();
        invalidUser = factory.createInvalidUser();
        users = factory.createUserVector();
    }

    private void saveUsers() {
        for (User user : users) {
            userRepository.saveUser(user);
        }
    }

    void testSaveUser() {
        userRepository.saveUser(user);
        assertEquals(1,userRepository.getSize());
        ArrayList<User> users = userRepository.getUsers();
        assertEquals(user,users[0]);
    }

    void testSaveInvalidUser() {
        userRepository.saveUser(invalidUser);
        assertEquals(userRepository.getSize(),0);
    }

    void testFindUserById() {
        saveUsers()
        User user = userRepository.findUserById(1);
        assertEquals(user.getUsername(),UserFactory.USERNAME);
        user = userRepository.findUserById(17);
        assertNull(user);
    }


    void testFindUserByUsername() {
        saveUsers();
        User user = userRepository.findUserByUsername(UserFactory.USERNAME);
        assertEquals(user.getUserID(),1);
        user = userRepository.findUserByUsername("blablabla");
        assertNull(user);
    }

}
