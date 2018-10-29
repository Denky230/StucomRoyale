
package management;

import model.Deck;
import model.Card;
import model.Shop;
import model.User;

public abstract class Manager {

    static final Shop SHOP = Shop.getInstance();

    public static void initStartingData() {
        UserManager.addUser("user_01", "123");
        UserManager.addUser("user_02", "123");
        UserManager.addUser("user_03", "123");
        UserManager.addUser("user_04", "123");

        SHOP.newCard("Troop", "Carta_01", 50, 5, 20, 2);
        SHOP.newCard("Troop", "Carta_02", 25, 20, 5, 2);
        SHOP.newCard("Troop", "Carta_03", 40, 30, 10, 5);
        SHOP.newCard("Structure", "Carta_04", 0, 0, 0, 0);
        SHOP.newCard("Structure", "Carta_05", 0, 0, 0, 0);
        SHOP.newCard("Structure", "Carta_06", 0, 0, 0, 0);
        SHOP.newCard("Spell", "Carta_07", 0, 0, 0, 0);
        SHOP.newCard("Spell", "Carta_08", 0, 0, 0, 0);
        SHOP.newCard("Spell", "Carta_09", 0, 0, 0, 0);

        /* TO TEST */
        User user_01 = UserManager.validateUser("user_01", "123");
        User user_02 = UserManager.validateUser("user_02", "123");
        user_01.getDeck().addCard(SHOP.getCards().get(0));
        user_01.getDeck().addCard(SHOP.getCards().get(1));
        user_01.getDeck().addCard(SHOP.getCards().get(2));
        user_02.getDeck().addCard(SHOP.getCards().get(0));
        user_02.getDeck().addCard(SHOP.getCards().get(1));
        user_02.getDeck().addCard(SHOP.getCards().get(2));
    }

    public static void getNewCards() {
        final int MAX_USER_CARDS = 6;

        User user = ViewManager.askForLogin();
        Deck userDeck = user.getDeck();

        // Show user cards
        ViewManager.showDeck(userDeck, "These are your cards", 1);

        // Make sure user is not card capped
        if (userDeck.getCards().size() >= MAX_USER_CARDS)
            throw new NullPointerException("You have reached the maximum number of cards allowed ("+MAX_USER_CARDS+").");

        // Show shop and ask user for a card/s he doesn't already have
        ViewManager.showDeck(SHOP, "*** Shop Cards ***", 1);
        Card[] cardChoices = ViewManager.chooseCardsFromDeck(SHOP, userDeck);

        // Add multiple cards to user deck
        for (Card cardChoice : cardChoices) {
            if (userDeck.addCard(cardChoice))
                ViewManager.soutNewAddedCard(cardChoice);
            else throw new NullPointerException("There was an error when adding your new card ("+cardChoice.getName()+")");
        }
    }

    public static void battle() {
        final int PLAYER_NUM_CARDS = 3;
        final int PLAYER_ELIXIR_CAP = 10;

        // Validate both players
        User player_01 = ViewManager.askForLogin();
        User player_02 = ViewManager.askForLogin();

        // Decks used in battle (not whole user decks)
        Deck player_01_battleDeck = buildBattleDeck(player_01, PLAYER_NUM_CARDS, PLAYER_ELIXIR_CAP);
    }

    static Deck buildBattleDeck(User user, int cards, int elixirCap) {
        int elixirLeftToSpend = elixirCap;

        ViewManager.showDeck(user.getDeck(), "*** Player 1 ***");

        Deck battleDeck = new Deck();
        while (battleDeck.getCards().size() < cards) {
//            Card cardChoice = ViewManager.chooseCardsFromDeck(user.getDeck(), battleDeck);
//            addCardsToBattleDeck(battleDeck, cardChoice, elixirLeftToSpend);
        }

        return null;
    }

//    static Deck buildValidChoicesDeck(Deck deck, int maxElixirCost) {
//        Deck validChoices = new Deck();
//        for (Card card : deck.getCards()) {
//            if (card.getCost() <= maxElixirCost)
//                validChoices.addCard(card);
//        }
//
//        return validChoices;
//    }

//    static boolean addCardsToBattleDeck(Deck deck, Card[] cards, int maxElixirCost) {
//        if (card.getCost() <= maxElixirCost) {
//            deck.getCards().add(card);
//            return true;
//        } else return false;
//    }
}