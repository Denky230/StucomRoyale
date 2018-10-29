
package model;

public class User {
    private String username;
    private String password;
    private int trophies;
    private final Deck deck = new Deck();

    public User(String username, String password, int numTrophies) {
        this.username = username;
        this.password = password;
        this.trophies = numTrophies;
    }
    public User(String username, String password) {
        this(username, password, 0);
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getNumTrophies() { return trophies; }
    public void setNumTrophies(int trophies) { this.trophies = trophies; }

    public Deck getDeck() { return deck; }
}