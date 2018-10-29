
package stucomroyale;

import management.Manager;
import utils.Reader;

public class StucomRoyale {

    /*
        *** TO DO ***
        - make sure user cant add more cards than he can hold
        *** TO MAYBE DO ***
        - getNewCard() >> getNewCards()
    */

    public static void main(String[] args) {
        // Menu variables
        boolean exit = false;
        boolean validOption;
        int menuOption;

        Manager.initStartingData();

        // App loop
        while (!exit) {
            System.out.println(
                "\n*** Stucom Royale ***\n"
                + "1 - Get new cards\n"
                + "2 - Battle\n"
                + "3 - Ranking\n"
                + "0 - Exit\n"
                + "*********************"
            );

            do {
                validOption = true;
                menuOption = Reader.nextInt();

                try {
                    switch (menuOption) {
                        case 1: // GET CARD
                            Manager.getNewCards();
                            break;
                        case 2: // BATTLE
                            Manager.battle();
                            break;
                        case 3: // RANKING
                            break;
                        case 0: // EXIT
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid option selected. Choose a valid one!");
                            validOption = false;
                    }
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }
            } while (!validOption);
        }
    }
}