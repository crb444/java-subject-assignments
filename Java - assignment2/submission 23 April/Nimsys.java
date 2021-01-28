import java.util.Scanner;

public class Nimsys {

    public static void main(String[] args) {
        String function, userinput;
        String addPlayer = "addplayer", removePlayer = "removeplayer", displayPlayer = "displayplayer", editPlayer = "editplayer",
                resetPlayer = "resetstats", exit = "exit", startgame = "startgame", rankings = "rankings";
        int playerCounter = 0;

        NimGame newGame = new NimGame ();

        NimPlayer[] players = new NimPlayer[50];

        NimPlayer playerFunctions = new NimPlayer ();

        Scanner keyboard = new Scanner ( System.in );

        System.out.println("Welcome to Nim.\n");



        for (int k = 0; ; k++) {
            System.out.print ( "$" );


            function = keyboard.next ();


            if (function.equalsIgnoreCase ( addPlayer )) {

                userinput = keyboard.next ();

                String[] input = userinput.split ( "," );
                String username = input[0];
                String firstname = input[1];
                String lastname = input[2];

                if (playerCounter == 0) {
                    playerCounter = playerFunctions.addPlayer ( players, username, firstname, lastname, playerCounter );
                } else {
                    int result = playerFunctions.playerChecker ( players, username, playerCounter );
                    if (result == 1) {
                        System.out.print ( "The player already exists.\n" );
                    }  else {
                        playerCounter = playerFunctions.addPlayer ( players, username, firstname, lastname, playerCounter );
                    }
                }
                System.out.print("\n");
            } else if (function.equalsIgnoreCase ( displayPlayer )) {
                userinput = keyboard.nextLine ();

                if (userinput.isEmpty ()) {
                    playerFunctions.displayAllPlayers ( players, playerCounter );
                } else {
                    String[] input = userinput.split ( "," );
                    String username = input[0];

                    int checkPlayer = playerFunctions.playerChecker ( players, username, playerCounter );

                    if (checkPlayer == 1) {
                        playerFunctions.displayPlayer ( players, username, playerCounter );
                    } else if (checkPlayer == 2) {
                        System.out.print ( "The player does not exist.\n" );
                    }
                }

            } else if (function.equalsIgnoreCase ( removePlayer )) {
                String userInput, yes = "y", no = "n", empty = " ";

                userinput = keyboard.nextLine ();

                if (userinput.isEmpty ()) {
                    System.out.println ( "Are you sure you want to remove all users? (y/n)" );
                    userInput = keyboard.nextLine ();
                    if (yes.equalsIgnoreCase ( userInput )) {
                        playerFunctions.removeAllPlayers ( players, playerCounter );
                    }
                } else {
                    String[] input = userinput.split ( "," );
                    String username = input[0];

                    int checkPlayer = playerFunctions.playerChecker ( players, username, playerCounter );

                    if (checkPlayer == 1) {
                        playerFunctions.removePlayer ( players, username, playerCounter );
                    } else if (checkPlayer == 2) {
                        System.out.print ( "The player does not exist.\n" );
                    }

                }

            } else if (function.equalsIgnoreCase ( editPlayer )) {
                userinput = keyboard.next ();

                String[] input = userinput.split ( "," );
                String username = input[0];
                String firstname = input[1];
                String lastname = input[2];

                int checkPlayer = playerFunctions.playerChecker ( players, username, playerCounter );
                if (checkPlayer == 1) {
                    playerFunctions.editPlayer ( players, firstname, lastname, playerCounter );
                } else if (checkPlayer == 2) {
                    System.out.print ( "The player does not exist.\n" );
                }

            } else if (function.equalsIgnoreCase ( resetPlayer )) {
                String userInput, yes = "y", no = "n", empty = " ";

                userinput = keyboard.nextLine ();

                if (userinput.isEmpty ()) {
                    System.out.println ( "Are you sure you want to reset all player statistics? (y/n)" );
                    userInput = keyboard.nextLine ();
                    if (yes.equalsIgnoreCase ( userInput )) {
                        playerFunctions.resetAllStats ( players, playerCounter );
                    }
                } else {
                    String[] input = userinput.split ( "," );
                    String username = input[0];

                    int checkPlayer = playerFunctions.playerChecker ( players, username, playerCounter );

                    if (checkPlayer == 1) {
                        playerFunctions.resetPlayerStats ( players, username, playerCounter );
                    } else if (checkPlayer == 2) {
                        System.out.print ( "The player does not exist.\n" );
                    }

                }
            } else if ((function.equalsIgnoreCase ( startgame ))) {
                int player_check = 0;

                userinput = keyboard.next ();

                String[] input = userinput.split ( "," );
                String initialstones = input[0];
                int initialStones = Integer.parseInt ( initialstones );
                String upperbound = input[1];
                int upperBound = Integer.parseInt ( upperbound );
                String username1 = input[2];
                String username2 = input[3];

                int checkPlayer1 = playerFunctions.playerChecker ( players, username1, playerCounter );
                if (checkPlayer1 == 1) {
                    player_check ++;
                } else if (checkPlayer1 == 2) {
                    System.out.print ( "One player does not exist.\n" );
                }

                int checkPlayer2 = playerFunctions.playerChecker ( players, username2, playerCounter );
                if (checkPlayer2 == 1) {
                    player_check ++;
                } else if (checkPlayer2 == 2) {
                    System.out.print ( "One player does not exist.\n" );
                }

                if(player_check == 2) {

                    int player1Index = playerFunctions.retrievePlayerIndex(players, username1, playerCounter);
                    int player2Index = playerFunctions.retrievePlayerIndex(players, username2, playerCounter);

                    System.out.println ( "\nInitial stone count: " + initialstones );
                    System.out.println ( "Maximum stone removal is: " + upperbound );
                    System.out.println ( "Player 1: " + username1 );
                    System.out.println ( "Player 2: " + username2 );


                    newGame.startNewGame ( initialStones, upperBound, player1Index, player2Index, keyboard, players );

                    System.out.print("\n");
                    keyboard.nextLine ();
                }

            } else if (function.equalsIgnoreCase ( rankings )) {



                players[0] = new NimPlayer ();
                players[0].userName = "lsky";
                players[0].firstName = "Luke";
                players[0].lastName = "Skywalker";
                players[0].gamesPlayed = 10;
                players[0].gamesWon = 10;
                players[0].winPercentage = ((double)(players[0].gamesWon)/(double)(players[0].gamesPlayed))*100.0;



                players[1] = new NimPlayer ();
                players[1].userName = "dvad";
                players[1].firstName = "Darth";
                players[1].lastName = "Vader";
                players[1].gamesPlayed = 20;
                players[1].gamesWon = 20;
                players[1].winPercentage = ((double)(players[1].gamesWon)/(double)(players[1].gamesPlayed))*100.0;

                players[2] = new NimPlayer ();
                players[2].userName = "hsolo";
                players[2].firstName = "Han";
                players[2].lastName = "Solo";
                players[2].gamesPlayed = 6;
                players[2].gamesWon = 6;
                players[2].winPercentage = ((double)(players[2].gamesWon)/(double)(players[2].gamesPlayed))*100.0;

                players[3] = new NimPlayer ();
                players[3].userName = "ptco";
                players[3].firstName = "Peter";
                players[3].lastName = "McDoherty";
                players[3].gamesPlayed = 6;
                players[3].gamesWon = 1;
                players[3].winPercentage = ((double)(players[3].gamesWon)/(double)(players[3].gamesPlayed))*100.0;

                players[4] = new NimPlayer ();
                players[4].userName = "sks";
                players[4].firstName = "General";
                players[4].lastName = "Snokes";
                players[4].gamesPlayed = 6;
                players[4].gamesWon = 1;
                players[4].winPercentage = ((double)(players[4].gamesWon)/(double)(players[4].gamesPlayed))*100.0;

                playerCounter = 5;


                userinput = keyboard.nextLine ();

                if (userinput.isEmpty ()) {
                    playerFunctions.rankingsAllPlayers (players, playerCounter);
                } else {
                    String[] input = userinput.split ( "," );
                    String username = input[0];

                }

            } else if ((function.equalsIgnoreCase ( exit ))) {
                System.exit ( 0 );
            } else {
                break;
            }
        }

    }
}

