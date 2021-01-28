/**
 * The NimGame class controls the game mechanics of Nim from Project A. Players
 * take turns removing stones from a total that is set at the
 * beginning of the game. The number of stones that the player removes must be less than
 * the upper bound value set at the beginning of the game. The player that avoids being the one
 * to remove the last stone is declared the winner.
 *
 */



import java.util.Scanner;

public class NimGame {

    public void startNewGame(int initialStones, int upperBound, int player1, int player2,
                             Scanner keyboard, NimPlayer[] players) {


        int playerTurnCounter = 1;


        players[player1].setGamesPlayed ();
        players[player2].setGamesPlayed ();

        int stones = initialStones;

        while (stones != 0) {
            System.out.printf ( "\n%d stones left: ", stones );
            stonePrinter ( stones );



            for(int playerMoveCounter=0; ; playerMoveCounter++) {

                int removeStones = removeStone ( players[player1].getFirstName (),
                        players[player2].getFirstName (), playerTurnCounter, upperBound,
                        keyboard );

                int stonesNew = stones - removeStones;

                if (stonesNew != stones) {
                    stones = stonesNew;
                    break;
                }

            }

            playerTurnCounter++;


            if (stones == 0) {
                System.out.println ( "\nGame Over" );

                if (playerTurnCounter % 2 != 0) {
                    System.out.println ( players[player1].getFirstName () + " " +
                            players[player1].getLastName () + " wins!" );
                    players[player1].setWonGame ();
                } else {
                    System.out.println ( players[player2].getFirstName () + " " +
                            players[player2].getLastName () + " wins!" );
                    players[player2].setWonGame ();
                }

                break;
            }
        }

    }

    public void stonePrinter (int stones) {

        for (int i = 0; i < stones; i++) {
            if(i == stones -1 ) {
                System.out.print ("*");
            } else {
                System.out.print ("* ");
            }
        }
    }

    public int removeStone (String player1, String player2, int playerTurnCounter, int upperBound,
                            Scanner keyboard) {

        if(playerTurnCounter % 2 != 0) {
            System.out.println ( "\n" + player1 + "'s turn - remove how many?" );
        } else {
            System.out.println ( "\n" + player2 + "'s turn - remove how many?" );
        }

        int removeStones = keyboard.nextInt ();
        if (removeStones > upperBound) {
            System.out.println("\nInvalid move. You must remove between 1 and "
                    + upperBound + " stones.");
            return 0;
        } else {
            return removeStones;
        }

    }
}





