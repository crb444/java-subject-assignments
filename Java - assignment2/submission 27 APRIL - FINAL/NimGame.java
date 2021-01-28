import java.util.Scanner;

public class NimGame {

    public void startNewGame(int initialStones, int upperBound, int player_1, int player_2, Scanner keyboard, NimPlayer[] players) {

        int playerTurnCounter = 1;


        NimPlayer player1 = new NimPlayer ();

        NimPlayer player2 = new NimPlayer ();

        NimPlayer system = new NimPlayer ();



                players[player_1].gamesPlayed++;
                players[player_2].gamesPlayed++;

                int stones = initialStones;

                while (stones != 0) {
                    System.out.printf ( "\n%d stones left: ", stones );
                    stonePrinter ( stones );



                    for(int playerMoveCounter=0; ; playerMoveCounter++) {

                        int removeStones = removeStone ( players[player_1].getFirstName (), players[player_2].getFirstName (), playerTurnCounter, upperBound, keyboard );

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
                            System.out.println ( players[player_1].getFirstName () + " " + players[player_1].getLastName () + " wins!" );
                            players[player_1].setWonGame ();
                        } else {
                            System.out.println ( players[player_2].getFirstName () + " " + players[player_2].getLastName () + " wins!" );
                            players[player_2].setWonGame ();
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

    public int removeStone (String player1, String player2, int playerTurnCounter, int upperBound, Scanner keyboard) {
        if(playerTurnCounter % 2 != 0) {
            System.out.println ( "\n" + player1 + "'s turn - remove how many?" );
        } else {
            System.out.println ( "\n" + player2 + "'s turn - remove how many?" );
        }

        int remove_stones = keyboard.nextInt ();
        if (remove_stones > upperBound) {
            System.out.println("\nInvalid move. You must remove between 1 and " + upperBound + " stones.");
            return 0;
        } else {
            return remove_stones;
        }

    }
}





