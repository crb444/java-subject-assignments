
/**
 * The Nimsys program implements the mathematical strategy game of Nim from Project A. In this
 * iteration of the program, the functionality of player management is added into the game through
 * an idle state. The idle state allows users to: add players, remove players, edit existing players,
 * reset player statistics, display player information and also rank players by win percentage.
 *
 * Author: Chamira Balasuriya
 * Last modified: 29-04-2018
 * Developed for COMP90041 Semester 1 2018
 */



import java.util.Arrays;
import java.util.Scanner;

public class Nimsys {

    public static void main(String[] args) {

        /* The following String variables correspond to the commands that a user may enter during
         * the idle state of the program to evoke a particular action. These are compared against
         * what the user actually entered to determine the action that needs to take place.
         */

        String function, userinput;
        String addPlayer = "addplayer", removePlayer = "removeplayer", displayPlayer =
                "displayplayer", editPlayer = "editplayer",
                resetPlayer = "resetstats", exit = "exit", startgame = "startgame",
                rankings = "rankings";
        int playerCounter = 0, maxPlayers = 100;

        NimPlayer[] players = new NimPlayer[maxPlayers];

        Scanner keyboard = new Scanner ( System.in );

        System.out.println("Welcome to Nim\n");

        /*players[0] = new NimPlayer ();
        players[0].setPlayer ( "lsky", "Luke", "Skywalker" );
        players[0].manualSetGames ( 10,20 );

        players[1] = new NimPlayer ();
        players[1].setPlayer ( "dvad", "Darth", "Vader" );
        players[1].manualSetGames ( 10,20 );

        players[2] = new NimPlayer ();
        players[2].setPlayer ( "hsolo", "Han", "Solo" );
        players[2].manualSetGames ( 10,20 );

        players[3] = new NimPlayer ();
        players[3].setPlayer ( "bfet", "Bobba", "Fett" );
        players[3].manualSetGames ( 10,20 );

        players[4] = new NimPlayer ();
        players[4].setPlayer ( "plei", "Leia", "Skywalker" );
        players[4].manualSetGames ( 10,40 );

        playerCounter = 5;*/


        /* The for loop makes sure that the user is able to keep entering commands - the only
         * way to exit is with the exit function. The function variable captures the first part
         * of the users input and compares it against each condition in the conditional statement
         * to determine the correct action. If an input doesn't match the options available,
         * an error message appears.

         */

        for (int k = 0; ; k++) {
            System.out.print ( "$" );


            function = keyboard.next ();

            String userInput = keyboard.nextLine ();

            int count = 0;

            for(int i =0; i < userInput.length (); i++) {
                if(userInput.charAt ( i ) == comma) {
                    count++;
                }
            }

            if(userInput.isEmpty ()) {
                inputLength = 0;
            } else if (count >= 2) {
                inputLength =3;
            }


            validateUserInput ( function, inputLength, userInput );



           /* if (function.equalsIgnoreCase ( addPlayer )) {

                userinput = keyboard.next ();

                String[] input = userinput.split ( "," );
                String username = input[0];
                String lastname = input[1];
                String firstname = input[2];



                playerCounter = addPlayer(players, username, lastname, firstname, playerCounter,
                        maxPlayers);

                System.out.print("\n");

            } else if (function.equalsIgnoreCase ( displayPlayer )) {
                userinput = keyboard.nextLine ();



                if (userinput.isEmpty ()) {
                    displayAllPlayers ( players, playerCounter );
                } else {
                    String[] input = userinput.split ( "," );
                    String username = input[0];


                    if (playerChecker ( players, username, playerCounter )) {
                        displayPlayer ( players, username, playerCounter );
                    } else {
                        System.out.print ( "The player does not exist.\n" );
                        System.out.print ("\n");
                    }
                }

            } else if (function.equalsIgnoreCase ( removePlayer )) {

                removePlayerFunction (keyboard, players, playerCounter);


            } else if (function.equalsIgnoreCase ( editPlayer )) {

                editPlayerFunction (keyboard, players, playerCounter);


            } else if (function.equalsIgnoreCase ( resetPlayer )) {

                resetPlayerFunction(keyboard, players, playerCounter);

            } else if ((function.equalsIgnoreCase ( startgame ))) {

                userinput = keyboard.next ();

                String[] input = userinput.split ( "," );
                String initialstones = input[0];
                int initialStones = Integer.parseInt ( initialstones );
                String upperbound = input[1];
                int upperBound = Integer.parseInt ( upperbound );
                String username1 = input[2];
                String username2 = input[3];


                startGameFunction(players, keyboard, playerCounter, username1, username2,
                        initialStones, upperBound);


            } else if (function.equalsIgnoreCase ( rankings )) {

                userinput = keyboard.nextLine ();



                if (userinput.isEmpty ()) {
                    String order = "desc";
                    rankingsAllPlayers (players, playerCounter, order);
                } else {
                    String[] input = userinput.split ( "," );
                    String order = input[0];

                    rankingsAllPlayers (players, playerCounter, order);
                }

            } else if ((function.equalsIgnoreCase ( exit ))) {
                System.out.print ("\n");
                System.exit ( 0 );
            } else {
                System.out.println ("Error - Invalid input.");
            } /*
        }

    }

    /* the 'addPlayer' method adds players into the memory and at the same time checks for duplicate
     * usernames, whilst also keeping count of the number of players entered through the playerCounter
     * variable.
     */


    static int addPlayer (NimPlayer[] players, String username, String lastname, String firstname,
                          int playerCounter, int maxPlayers) {
        if (playerCounter == 0) {
            players[playerCounter] = new NimPlayer ();
            players[playerCounter].setPlayer ( username, firstname, lastname );
            playerCounter++;

        } else if (playerCounter == maxPlayers && !(nullSearch ( players, playerCounter ))) {
            System.out.println ("Maximum number of players reached");
        } else {
            if (playerChecker ( players, username, playerCounter )) {
                System.out.print ( "The player already exists.\n" );
            } else {
                if (nullSearch ( players, playerCounter )) {
                    int index = nullSearchIndex ( players, playerCounter );
                    players[index].setPlayer ( username, firstname, lastname );
                } else {
                    players[playerCounter] = new NimPlayer ();
                    players[playerCounter].setPlayer ( username, firstname, lastname );
                    playerCounter++;
                }
            }
        }
        return playerCounter;
    }

    /* When a player is removed, their player details are set to 'null'. The below method and
     * the following nullSearchIndex checks for the first index value with 'null'. This is used in
     * the above addPlayer method to ensure that when a player wants to be added and there is a
     * null player, the players details are overwritten over the null player.
     *
     */


    static boolean nullSearch (NimPlayer[] players, int playerCounter) {
        String nullPlayer = "null";

        for(int i =0; i < playerCounter; i++) {
            if(players[i].getUserName ().equalsIgnoreCase ( nullPlayer )) {
                return true;
            }
        }
        return false;

    }

    static int nullSearchIndex (NimPlayer[] players, int studentCounter) {
        String nullPlayer = "null";
        int index =0;

        for(int i =0; i < studentCounter; i++) {
            if (players[i].getUserName ().equalsIgnoreCase ( nullPlayer )) {
                index=  i;
            }
        }
        return index;
    }

    /* The playerChecker method determines if a player with the same username as the one inputted
     * by the user actually exists. This is used during all idle functions.
     *
     */

    static boolean playerChecker(NimPlayer[] players, String username, int playerCounter) {
        for (int i = 0; i < playerCounter; i++) {
            if (players[i].getUserName ().equalsIgnoreCase ( username.replaceAll ( " ", "" ) )) {
                return true;
            }
        }
        return false;
    }

    /* The following method displays information for all players. An empty String[] is created to
     * store the usernames of the existing players and then sorted. The sorted array finds the
     * corresponding details of the player in the players[] and displays their details. Note that this
     * also skips null values and does not print them out.
     *
     */

    static void displayAllPlayers(NimPlayer[] players, int playerCounter) {
        String empty = "null";
        String[] userNameOrder = new String[playerCounter];

        for(int j=0; j < playerCounter; j++) {
            userNameOrder[j] = players[j].getUserName ();
        }

        Arrays.sort(userNameOrder);


        for(int i=0; i<playerCounter; i++) {
            if (!userNameOrder[i].equalsIgnoreCase ( empty )) {
                for (int k = 0; k < playerCounter; k++) {
                    if (userNameOrder[i].equalsIgnoreCase ( players[k].getUserName () )) {
                        System.out.print ( players[k].getUserName () + "," );
                        System.out.print ( players[k].getFirstName () + "," );
                        System.out.print ( players[k].getLastName () + "," );
                        System.out.print ( players[k].getGamesPlayed () + " games," );
                        System.out.print ( players[k].getGamesWon () + " wins" );
                        System.out.print ( "\n" );
                    }
                }
            }
        }

        System.out.print ( "\n" );

    }

    /* This method takes the user input of a particular username and searches for that player to
     * display their details.
     *
     */

    static void displayPlayer(NimPlayer[] players, String username, int playercounter) {

        for (int i = 0; i < playercounter; i++) {
            if (players[i].getUserName ().equalsIgnoreCase ( username.replaceAll ( " ", "" ) )) {
                System.out.print (players[i].getUserName() + ",");
                System.out.print (players[i].getFirstName () + ",");
                System.out.print (players[i].getLastName () + ",");
                System.out.print (players[i].getGamesPlayed () + " games,");
                System.out.print (players[i].getGamesWon () + " wins");
                System.out.println ("\n");
                i++;
            }
        }
    }

    /* The removePlayerFunction method checks whether the user specified a single username or not.
     * If the user didn't specify a single user, all players are removed upon confirmation, else
     * a particular player is removed upon checking if the player actually exists.
     *
     */

    static void removePlayerFunction (Scanner keyboard, NimPlayer[] players, int playerCounter) {
        String yes = "y", no = "n", empty = " ";

        String userinput = keyboard.nextLine ();

        if (userinput.isEmpty ()) {
            System.out.println ( "Are you sure you want to remove all players? (y/n)" );
            String userInput = keyboard.nextLine ();
            if (yes.equalsIgnoreCase ( userInput )) {
                removeAllPlayers ( players, playerCounter );
            }
        } else {
            String[] input = userinput.split ( "," );
            String username = input[0];


            if (playerChecker ( players, username, playerCounter )) {
                removePlayer ( players, username, playerCounter );
            } else {
                System.out.println ( "The player does not exist.\n" );
            }
        }
    }

    /* The method below is evoked after the user enters the editplayer function. The method has the
     * single role of determining if there is a player with the username that was entered by the user.
     *
     */

    static void editPlayerFunction(Scanner keyboard, NimPlayer[] players, int playerCounter ) {
        String userinput = keyboard.next ();

        String[] input = userinput.split ( "," );
        String username = input[0];
        String lastname = input[1];
        String firstname = input[2];

        if (playerChecker ( players, username, playerCounter )) {
            editPlayer ( players, username, firstname, lastname, playerCounter );
        } else {
            System.out.print ( "The player does not exist.\n" );
            System.out.print ("\n");
        }
    }

    /* The following method changes sets the new first and last names of the player.
     *
     */

    static void editPlayer(NimPlayer[] players, String username, String firstname, String lastname,
                           int playerCounter) {

        for (int i = 0; i < playerCounter; i++) {
            if (players[i].getUserName ().equalsIgnoreCase ( username )) {
                players[i].setFirstAndLastNames ( firstname,lastname );
                break;
            }
        }
        System.out.print ("\n");
    }


    /* The following method searches for  a particular player based on username and sets their
     * username, firstname and lastname to null - essentially deleting them from the system.
     */

    static void removePlayer(NimPlayer[] players, String username, int playerCounter) {
        String empty = "null";
        for (int i = 0; i < playerCounter; i++) {
            if (players[i].getUserName ().equalsIgnoreCase ( username.replaceAll ( " ", "" ) )) {
                players[i].setPlayer ( empty, empty, empty);
            }
        }
        System.out.print("\n");
    }

    /* The following method removes all players from the system.
     *
     */

    static void removeAllPlayers(NimPlayer[] players, int playerCounter) {
        String empty = "null";
        for (int i = 0; i < playerCounter; i++) {
            players[i].setPlayer ( empty, empty, empty);
        }
        System.out.print ("\n");
    }

    /* The following method is evoked when the user enters the resetplayer option. The method
     * determines whether the user wants to reset all player statistics or the statistics of a
     * particular player.
     *
     */

    static void resetPlayerFunction (Scanner keyboard, NimPlayer[] players, int playerCounter) {
        String yes = "y", no = "n", empty = " ";

        String userinput = keyboard.nextLine ();

        if (userinput.isEmpty ()) {
            System.out.println ( "Are you sure you want to reset all player statistics? (y/n)" );
            String userInput = keyboard.nextLine ();
            if (yes.equalsIgnoreCase ( userInput )) {
                resetAllStats ( players, playerCounter );
            }
        } else {
            String[] input = userinput.split ( "," );
            String username = input[0];


            if (playerChecker ( players, username, playerCounter )) {
                resetPlayerStats ( players, username, playerCounter );
            } else {
                System.out.print ( "The player does not exist.\n" );
            }

        }
    }

    /* The following two methods reset all player statistics or specific player statistics.
     *
     */

    static void resetAllStats(NimPlayer[] players, int playercounter) {
        for (int i = 0; i < playercounter; i++) {
            players[i].resetGamesWon (  );
            players[i].resetGamesPlayed ();
        }
    }

    static void resetPlayerStats(NimPlayer[] players, String username, int playercounter) {
        for (int i = 0; i < playercounter; i++) {
            if (players[i].getUserName ().equalsIgnoreCase ( username.replaceAll ( " ", "" ) )) {
                players[i].resetGamesPlayed ();
                players[i].resetGamesWon ();
                break;
            }
        }
    }

    /* The following method checks if the two users who want to start the game actually exist.
     * The game is only started when the playerCheck variable is equal to 2 - indicating that
     * both players exist.
     *
     */

    static void startGameFunction(NimPlayer[] players, Scanner keyboard, int playerCounter,
                                  String username1, String username2, int initialStones,
                                  int upperBound) {

        int player_check = 0;


        if (playerChecker ( players, username1, playerCounter )) {
            player_check++;
        } else {
            System.out.print ( "One player does not exist.\n" );
        }

        if (playerChecker ( players, username2, playerCounter )) {
            player_check++;
        } else {
            System.out.print ( "One player does not exist.\n" );
        }

        if (player_check == 2) {

            int player1Index = retrievePlayerIndex ( players, username1, playerCounter );
            int player2Index = retrievePlayerIndex ( players, username2, playerCounter );

            System.out.println ( "\nInitial stone count: " + initialStones );
            System.out.println ( "Maximum stone removal: " + upperBound );
            System.out.println ( "Player 1: " + players[player1Index].getFirstName () + " " +
                    players[player1Index].getLastName () );
            System.out.println ( "Player 2: " + players[player2Index].getFirstName () + " " +
                    players[player2Index].getLastName () );


            NimGame newGame = new NimGame ();
            newGame.startNewGame ( initialStones, upperBound, player1Index, player2Index, keyboard,
                    players );

            System.out.print ( "\n" );
            keyboard.nextLine ();
        }
    }

    /* The following method retrieves the index value of a particular player.
     *
     */

    static int retrievePlayerIndex(NimPlayer[] players, String userName, int playerCounter) {
        int index = 0;
        for (int i = 0; i < playerCounter; i++) {
            if (players[i].getUserName ().equalsIgnoreCase ( userName.replaceAll ( " ", "" ) )) {
                index = i;
                break;
            }
        }
        return index;
    }

    /* The following is the beginning method of the ranking function. A new double[] is initialised
     * where the player win percentages are copied into.
     *
     */

    static void rankingsAllPlayers(NimPlayer[] players, int playerCounter, String userInput) {
        String desc = "desc", asc = "asc";
        int displayTen = 10;
        double[] playerWinPercentages = new double[playerCounter];

        String userInputOrder = userInput.replaceAll ( " ", "" );

        if (playerCounter > displayTen){
            playerCounter = displayTen;
        }


        for (int i = 0; i < playerCounter; i++) {
            playerWinPercentages[i] = players[i].calculateWinPercentage ();
        }

        Arrays.sort ( playerWinPercentages );


        if(userInputOrder.equalsIgnoreCase ( desc )) {
            reverseArray(playerWinPercentages);
        }


        int i =0;
        while(i <playerCounter) {
            if(i != playerCounter - 1 && (playerWinPercentages[i] == playerWinPercentages[i+1])) {
                int duplicates = duplicateCounter (playerWinPercentages, playerCounter,
                        playerWinPercentages[i]);
                duplicateSorter(playerWinPercentages, players, playerCounter, playerWinPercentages[i],
                        duplicates);
                i = i + duplicates;
            } else {
                for(int k =0; k <playerCounter ; k++) {
                    if(players[k].getWinPercentage () == playerWinPercentages[i]) {
                        playerRankFormatting ( players, players[k].getUserName (), playerCounter );
                    }
                }
                i = i + 1;
            }
        }

    }

    static double[] reverseArray(double[] playerWinPercentages) {
        int start=0, end =0;
        double tmp;

        end = playerWinPercentages.length-1;

        while(start < end) {
            tmp = playerWinPercentages[start];
            playerWinPercentages[start] = playerWinPercentages[end];
            playerWinPercentages[end] = tmp;
            start++;
            end--;
        }

        return playerWinPercentages;

    }

    static int duplicateCounter (double[] playerWinPercentages, int playerCounter, double
            duplicateValue) {
        int counter =0;

        for(int i =0 ; i < playerCounter; i++) {
            if(playerWinPercentages[i] == duplicateValue) {
                counter++;
            }
        }
        return counter;
    }

    static void duplicateSorter(double[] playerWinPercentages, NimPlayer[] players, int
            playerCounter, double duplicateValue, int duplicates) {

        String[] duplicateNames = new String[duplicates];
        int duplicateNameCounter = 0;

        for(int i =0 ; i < playerCounter; i++) {
            if(players[i].getWinPercentage () == duplicateValue) {
                duplicateNames[duplicateNameCounter] = players[i].getUserName ();
                duplicateNameCounter++;
            }
        }

        Arrays.sort(duplicateNames);
        int length = duplicateNames.length;

        for(int k=0; k < length; k++) {
            playerRankFormatting ( players, duplicateNames[k], playerCounter );
        }

    }

    static void playerRankFormatting (NimPlayer[] players, String index, int playerCounter) {
        int indexValue =0;

        for(int i=0; i < playerCounter; i++) {
            if(players[i].getUserName ().equalsIgnoreCase ( index )) {
                indexValue = i;
                break;
            }
        }


        String playerPercentageInner =
                String.format ( "%1.0f%%", players[indexValue].getWinPercentage () );
        String playerPercentageOuter =
                String.format ( "%-4s", playerPercentageInner );
        System.out.print ( playerPercentageOuter );
        System.out.print ( " | " );
        String playerGamesPlayedInner =
                String.format ( "%02d", players[indexValue].getGamesPlayed () );
        String playerGamesPlayedOuter =
                String.format ( "%2s games ", playerGamesPlayedInner );
        System.out.print ( playerGamesPlayedOuter );
        System.out.print ( "| " );
        System.out.print ( players[indexValue].getFirstName () + " " + players[indexValue]
                .getLastName
                () );
        System.out.print ( "\n" );
    }




    static void rankingPrinter (String[] playerUserNames, NimPlayer[] players, int newLength,
                                int playerCounter, String userInput) {

        String empty = "null";
        String order = userInput.replaceAll ( " ", "" );

        if (order.equalsIgnoreCase ( "desc" )) {
            for (int i = newLength - 1; i >= 0; i--) {
                for (int j = 0; j < playerCounter; j++) {
                    if (playerUserNames[i].equalsIgnoreCase ( players[j].getUserName () )
                            && !playerUserNames[i].equalsIgnoreCase ( empty )) {
                        playerRankFormatting ( players, j );

                    }
                }
            }
        } else if (order.equalsIgnoreCase ( "asc" )) {
            for (int i = 0; i < newLength; i++) {
                for (int j = 0; j < playerCounter; j++) {
                    if (playerUserNames[i].equalsIgnoreCase ( players[j].getUserName () )
                            && !playerUserNames[i].equalsIgnoreCase ( empty )) {
                        playerRankFormatting ( players, j );

                    }
                }
            }
        }

        System.out.print ("\n");

    }

    /* This method prints out the rankings with the relevant formatting.
     *
     */

    static void playerRankFormatting (NimPlayer[] players, int index) {

        String playerPercentageInner =
                String.format ( "%1.0f%%", players[index].getWinPercentage () );
        String playerPercentageOuter =
                String.format ( "%-4s", playerPercentageInner );
        System.out.print ( playerPercentageOuter );
        System.out.print ( " | " );
        String playerGamesPlayedInner =
                String.format ( "%02d", players[index].getGamesPlayed () );
        String playerGamesPlayedOuter =
                String.format ( "%2s games ", playerGamesPlayedInner );
        System.out.print ( playerGamesPlayedOuter );
        System.out.print ( "| " );
        System.out.print ( players[index].getFirstName () + " " + players[index].getLastName () );
        System.out.print ( "\n" );
    }

            static void validateUserInput(String function, int inputLength, String userInput) {
                try{
                    validateFunction (function, inputLength );

                    String[] input = userInput.split ( "," );
                    String input1 = input[0].replaceAll ( " ", "" );
                    String input2 = input[1];
                    String input3 = input[2];

                    System.out.println (input1);
                    System.out.println (input[1]);
                    System.out.println (input[2]);

                } catch (Exception m) {
                    System.out.println (m.getMessage () );
                }
            }


            static void validateFunction(String userInput, int input)throws InvalidFunction {
                String addPlayer = "addplayer", displayPlayer = "displayplayer", editPlayer = "editplayer",
                        rankings = "rankings", exit = "exit", removePlayer = "removeplayer", resetPlayer
                        = "resetplayer", startgame = "startgame";


                if(!(userInput.equalsIgnoreCase ( addPlayer )) && !(userInput.equalsIgnoreCase (
                        displayPlayer )))
                {
                    throw new InvalidFunction ( "\"" + userInput + "\"" + " is not a valid command." );
                }

                if (userInput.equalsIgnoreCase ( addPlayer ) && input < 3) {
                    throw new InvalidFunction ("Incorrect number of arguments supplied to command.");
                }
            }

}

