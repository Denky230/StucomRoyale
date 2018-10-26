
package model;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private int numTrophies;
    private final ArrayList<Card> deck;

    public User(String username, String password, int numTrophies) {
        this.username = username;
        this.password = password;
        this.numTrophies = numTrophies;
        this.deck = new ArrayList<>();
    }
    public User(String username, String password) {
        this(username, password, 0);
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumTrophies() {
        return numTrophies;
    }
    public void setNumTrophies(int numTrophies) {
        this.numTrophies = numTrophies;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
