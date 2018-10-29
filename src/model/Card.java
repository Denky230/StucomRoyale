
package model;

public class Card {
    private String name;
    private int hp;
    private int atk;
    private int def;
    private int cost;

    public Card(String name, int hp, int atk, int def, int cost) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }
    public void setDef(int def) {
        this.def = def;
    }

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + getName() + " // HP: " + getHp() + " // Atk: " + getAtk() + " // Def: " + getDef() + " // Elixir cost: " + getCost();
    }
}