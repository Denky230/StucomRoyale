
package management;

import java.util.ArrayList;

import model.Card;
import model.User;
import utils.Reader;

public class Manager {

    public static void initStartingData() {
        UserManager.addUser("user_01", "123");
        UserManager.addUser("user_02", "123");
        UserManager.addUser("user_03", "123");
        UserManager.addUser("user_04", "123");

        CardManager.addCard("Carta_01", 0, 0, 0, 0);
        CardManager.addCard("Carta_02", 0, 0, 0, 0);
        CardManager.addCard("Carta_03", 0, 0, 0, 0);
    }

    public static User askForLogin() {
        System.out.println("Username:");
        String username = Reader.nextString();
        System.out.println("Password:");
        String password = Reader.nextString();

        return UserManager.validateUser(username, password);
    }

    public static void showCardsByUser(User user) {
        ArrayList<Card> userDeck = user.getDeck();

        if (!userDeck.isEmpty()) {
            for (Card card : userDeck) {
                System.out.println("Name: " + card.getName() + " / Attack: " + card.getAtk() + " / Defense: " + card.getDef());
            }
        } else System.out.println("The user " + user.getUsername() + " has no cards :(");
    }

    public static void battle() {
        // Validate both players
        User player_01 = askForLogin();
        User player_02 = askForLogin();

        // TO DO
        showCardsByUser(player_01);
    }
}
