
package management;

import java.util.ArrayList;
import model.Card;
import model.Deck;
import model.User;
import utils.Reader;

public class ViewManager {
    
    /**
     * Calls UserManager.validateUser() passing login + password input as arguments
     * @return User if login is correct
     * @throws NullPointerException
     * @see UserManager#validateUser(java.lang.String, java.lang.String)
     */
    static User askForLogin() {
        System.out.println("Username:");
        String username = Reader.nextString();
        System.out.println("Password:");
        String password = Reader.nextString();
        
        return UserManager.validateUser(username, password);
    }
    
    /**
     * List cards from <i>deck</i> indexed (only if indexOffset != -1).
     * @param deck deck
     * @param header string to sout before listing cards
     * @param indexOffset number at which to start list index, -1 will cancel indexing
     */
    static void showDeck(Deck deck, String header, int indexOffset) {
        ArrayList<Card> deckCards = deck.getCards();
        
        System.out.println(header);
        if (!deckCards.isEmpty()) {
            if (indexOffset != -1) {
                // Print indexed list
                for (Card card : deckCards) {
                    System.out.println(deckCards.indexOf(card) + indexOffset + " - " + card.toString());
                }
            } else {
                // Print non-indexed list
                for (Card card : deckCards) {
                    System.out.println(card.toString());
                }
            }
            System.out.println();
        } else throw new NullPointerException("Your deck is currently empty :(");
        
    }
    /**
     * showDeck(deck, header, indexOffset) with no index offset.
     * @see ViewManager#showDeck(model.Deck, java.lang.String, int)
     */
    static void showDeck(Deck deck, String header) {
        showDeck(deck, header, 0);
    }
    /**
     * showDeck(deck, header, indexOffset) with no index offset and "These are your cards" as header.
     * @see ViewManager#showDeck(model.Deck, java.lang.String, int)
     */
    static void showDeck(Deck deck) {
        showDeck(deck, "These are your cards:");
    }
    
    /**
     * Displays indexed deck list and asks for a card choice or 0 to exit.
     * @return chosen card or null if 0 was input
     */
    static Card chooseCardFromDeck(Deck deckToChooseFrom, Deck deckToChooseInto) {
        ArrayList<Card> deckCards = deckToChooseFrom.getCards();
        final int CODE_EXIT = 0;
        final int INDEX_OFFSET = 1;
        
        System.out.println("Choose a card or type 0 to exit");
        int cardIndex = Reader.nextInt(deckCards.size() + INDEX_OFFSET);
        
        if (cardIndex == CODE_EXIT)
            return null;
        
        // Make sure user does not already have chosen card
        Card cardChoice = deckCards.get(cardIndex - INDEX_OFFSET);
        while (deckToChooseInto.findCardByName(cardChoice.getName())) {
            System.out.println("You already are in possession of this card. Choose a different one!");
            cardIndex = Reader.nextInt(deckCards.size() + INDEX_OFFSET);
            cardChoice = deckCards.get(cardIndex - INDEX_OFFSET);
        }
        
        return cardChoice;
    }
    
    static void soutNewAddedCard(Card card) {
        System.out.println("The card " + card.getName() + " was succesfully added to your deck!");
    }
    static void soutNewAddedCard(Card card, int elixirLeft) {
        soutNewAddedCard(card);
        System.out.println("You have " + elixirLeft + " elixir left to spend");
    }
}