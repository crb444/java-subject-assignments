/**
 * The Nimsys program implements the mathematical strategy game of Nim. Players
 * take turns removing stones from a total that is set at the
 * beginning of the game. The number of stones that the player removes must be less than
 * the upper bound value set at the beginning of the game. The player that avoids being the one
 * to remove the last stone is declared the winner.
 *
 * Author: Chamira Balasuriya
 * Last modified: 29-03-2018
 * Developed for COMP90041 Semester 1 2018
 */


import java.util.Scanner;


public class Nimsys {

    public static void main(String[] args) {

        int playerTurnCounter=1;

        /* The above variable that is initialised keeps count of which players turn
        it is. It is initialised at 1 as Player 1 has the first turn. This counter is also used
        later in the program when determining the winner of the game.
        */



        Scanner keyboard = new Scanner ( System.in );

        NimPlayer player1 = new NimPlayer ();

        NimPlayer player2 = new NimPlayer ();

        NimPlayer system = new NimPlayer ();

        /* A instance of NimPlayer named system is created to perform functions
        that are not directly related to the individual players.
         */

        System.out.println("Welcome to Nim");

        System.out.println ("\nPlease enter Player 1's name:");

        player1.name = keyboard.nextLine ();

        System.out.println ("\nPlease enter Player 2's name:");

        player2.name = keyboard.nextLine ();

        System.out.println ("");

        /* The above gathers inputs for the names of the two players. The game counter
        initialised below in the for loop counts rounds of the game. This will make sure
        that the players can restart the game after it finishes.
         */

        for (int numberOfRounds = 0; ; numberOfRounds++) {

            System.out.println ("Please enter upper bound of stone removal:");

            int upperBound = keyboard.nextInt ();

            System.out.println ("\nPlease enter initial number of stones:");

            int stones = keyboard.nextInt ();

            /* The above sets crucial parameters needed for game play. The while loop below enables
            players to keep having turns until there are no stones left - in which the loop will
            break and a winner is declared.
             */


            while (stones != 0) {
                System.out.printf ( "\n%d stones left: ", stones );
                system.stonePrinter (stones);


                /* The loop below allows the selected player to determine how many stones to remove.
                This number is then utilised by a method in the NimPlayer class, to determine
                whether it is a legitimate move - if it is within the bounds. If so, loop is broken
                and it is the next players move. If the player does not enter a number within the
                bounds, they are asked repeatedly for new input.
                 */


                for(int playerMoveCounter=0; ; playerMoveCounter++) {
                    if(playerTurnCounter % 2 != 0) {
                        System.out.println ( "\n" + player1.name + "'s turn - remove how many?" );
                    } else {
                        System.out.println ( "\n" + player2.name + "'s turn - remove how many?" );
                    }

                    int remove_stones = keyboard.nextInt ();

                    int stones_new = player1.removeStone ( stones, remove_stones, upperBound );

                    if (stones_new != stones) {
                        stones = stones_new;
                        break;
                    }

                }

                /* The condition below determines which player had the last move based on the
                'playerTurnCounter' variable. If the variable is an odd number that means Player
                1 had the last move, thus the winner is Player 2. The same logic is applied when
                the variable is even, indicating that Player 2 had the last move.
                 */

                if (stones == 0) {
                    System.out.println ( "\nGame Over" );

                    if (playerTurnCounter % 2 != 0) {
                        System.out.println ( player2.name + " wins!" );
                    } else {
                        System.out.println ( player1.name + " wins!" );
                    }

                    break;
                }

                playerTurnCounter++;
            }

            System.out.print ("\nDo you want to play again (Y/N):");

            /* The below code determines whether there will be another round that will be played.
            The loop ensures that the player is able to input a response again if Y or N is not
            recognised. The playAgain method of class NimPlayer is called to determine the response.
             */

            for(int playAgainResponse=0; ; playAgainResponse++) {
                system.response = keyboard.next();

                int playerResponse = system.playAgain (system.response);

                if (playerResponse == 1){
                    System.out.println("");
                    break;
                } else {
                    System.out.println("\nPlease enter either Y or N");
                    keyboard.nextLine();
                }
            }
        }
    }
}

