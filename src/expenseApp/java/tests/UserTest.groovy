package expenseApp.java.tests

import expenseApp.java.domain.User
import expenseApp.java.factory.UserFactory

/**
 * Created by ZUZU on 07.10.2015.
 */
class UserTest extends GroovyTestCase {
    User u;

    void setUp() {
        UserFactory factory = new UserFactory();
        u = factory.createUser();
    }

    void testGetUsername() {
        assertEquals(u.getUsername(), UserFactory.USERNAME);
    }


    void testGetUserID() {
        assertEquals(u.getUserID(), 0);
    }
}
