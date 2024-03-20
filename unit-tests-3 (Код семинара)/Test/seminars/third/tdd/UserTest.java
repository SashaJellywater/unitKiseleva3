package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    @Test
    void userCreation(){
        User user = new User("user_0", "psw123", false);
        assertTrue(user.authenticate("user_0", "psw123"));
    }
    @Test
    void userCreationFailed(){
        User user = new User("user_0", "123psw", false);
        assertFalse(user.authenticate("user_0", "psw123"));
    }

    @Test
    void userRepository(){
        UserRepository userRepository = new UserRepository();
        User userNA = new User("user_0", "psw123", false);
        userRepository.addUser(userNA);
        assertFalse(userRepository.findByName(userNA.name));
    }
    @Test
    void userRepositoryNA(){
        UserRepository userRepository = new UserRepository();
        User userNA = new User("user_0", "psw123", false);
        userNA.authenticate("user_0", "psw123");
        userRepository.addUser(userNA);
        assertTrue(userRepository.findByName(userNA.name));
    }
    @Test
    public void testLogoutUsers() {
        UserRepository userRepository = new UserRepository();
        User adminUser = new User("admin", "password", true);
        User user_1 = new User("user_1", "psw123", false);
        User user_2 = new User("user_2", "psw1234", false);

        userRepository.addUser(adminUser);
        userRepository.addUser(user_1);
        userRepository.addUser(user_2);

        userRepository.logoutUsers();

        assertFalse(adminUser.isAuthenticate);
        assertFalse(user_1.isAuthenticate);
        assertFalse(user_2.isAuthenticate);
    }
}