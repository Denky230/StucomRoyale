
package management;

import java.util.ArrayList;
import model.Card;

public class CardManager {

    private static ArrayList<Card> cardPool = new ArrayList();

    static boolean findCardByName(String name) {
        for (Card card : cardPool) {
            if (card.getName().equals(name))
                return true;
        }

        return false;
    }

    /**
     * Adds a new card if its name is not being used.
     * @param name name
     * @param hp health points
     * @param atk attack
     * @param def defense
     * @param cost elixir cost
     * @return true if successfully added, false otherwise
     */
    public static boolean addCard(String name, int hp, int atk, int def, int cost) {
        if (!findCardByName(name)) {
            return cardPool.add(new Card(name, hp, atk, def, cost));
        } else return false;
    }

    public static ArrayList<Card> getCards() {
        return cardPool;
    }
}