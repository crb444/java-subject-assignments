import java.util.Scanner;

public class NimGame {

    public void startNewGame(int initialStones, int upperBound, int player_1, int player_2, Scanner keyboard, NimPlayer[] players) {

        int playerTurnCounter = 1;




        NimPlayer player1 = new NimPlayer ();

        NimPlayer player2 = new NimPlayer ();

        NimPlayer system = new NimPlayer ();

        System.out.println(players[player_1].firstName);
        System.out.println(players[player_2].firstName);



     /* HOW TO DO KEYBOARD INPUT
     System.out.print("This is a test" + username1);
        keyboard.nextLine ();
        System.out.print("Enter name");
        String name = keyboard.nextLine();
        System.out.print("Your name is : " + name);

*/
                players[player_1].gamesPlayed++;
                players[player_2].gamesPlayed++;

                int stones = initialStones;

                while (stones != 0) {
                    System.out.printf ( "\n%d stones left: ", stones );
                    system.stonePrinter (stones);



                    for(int playerMoveCounter=0; ; playerMoveCounter++) {
                        if(playerTurnCounter % 2 != 0) {
                            System.out.println ( "\n" + players[player_1].firstName + "'s turn - remove how many?" );
                        } else {
                            System.out.println ( "\n" + players[player_2].firstName + "'s turn - remove how many?" );
                        }

                        int remove_stones = keyboard.nextInt ();

                        int stones_new = players[player_1].removeStone ( stones, remove_stones, upperBound );


                        if (stones_new != stones) {
                            stones = stones_new;
                            break;
                        }

                    }


                    if (stones == 0) {
                        System.out.println ( "\nGame Over" );

                        if (playerTurnCounter % 2 != 0) {
                            System.out.println ( players[player_2].firstName + " wins!" );
                            players[player_2].gamesWon++;
                        } else {
                            System.out.println ( players[player_1].firstName + " wins!" );
                            players[player_1].gamesWon++;
                        }

                        break;
                    }

                    playerTurnCounter++;
                }
    }
}

