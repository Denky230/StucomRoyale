
package model;

public class Shop extends Deck {
    
    private static Shop instance = new Shop();
    
    private Shop() { super(); }
    
    public static Shop getInstance() { return instance; }
    
    /**
     * Card factory.
     * @return Card with given attributes
     */
    public void newCard(String cardType, String name, int hp, int atk, int def, int elixirCost) {        
        switch (cardType.toUpperCase()) {
            case "TROOP":
                addCard(new Troop(name, hp, atk, def, elixirCost));
            case "STRUCTURE":
                addCard(new Structure(name, hp, atk, def, elixirCost));
            case "SPELL":
                addCard(new Spell(name, hp, atk, def, elixirCost));
            default:
                // TO DO: throw some exception
        }
    }
}