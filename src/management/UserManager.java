
package management;

import java.util.ArrayList;
import model.User;

public class UserManager {

    private static ArrayList<User> users = new ArrayList<>();

    static User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(user))
                return user;
        }

        return null;
    }

    /**
     * @return User if login was correct
     * @throws NullPointerException 
     */
    public static User validateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }

        throw new NullPointerException("Incorrect username or password");
    }

    /**
     * Add new user if username is not being used (with 0 trophies).
     * @param username username
     * @param password password
     * @return true if was successfully added, false otherwise
     */
    public static boolean addUser(String username, String password) {
        if (findUser(username) == null) {
            return users.add(new User(username, password));
        } else return false;
    }

    /**
     * @param username username
     * @return true if successfully removed, false otherwise
     */
    public static boolean removeUser(String username) {
        return users.remove(findUser(username));
    }
}