
import java.util.Arrays;
import java.util.Scanner;

public class Nimsys {

    public static void main(String[] args) {
        String function, userinput;
        String addPlayer = "addplayer", removePlayer = "removeplayer", displayPlayer = "displayplayer", editPlayer = "editplayer",
                resetPlayer = "resetstats", exit = "exit", startgame = "startgame", rankings = "rankings";
        int playerCounter = 0, maxPlayers = 50;

        NimPlayer[] players = new NimPlayer[maxPlayers];


        Scanner keyboard = new Scanner ( System.in );

        System.out.println("Welcome to Nim\n");



/*
                players[0] = new NimPlayer ();
                players[0].setPlayer ( "george","Washington","George" );

                players[0].gamesPlayed = 3;
                players[0].setGamesWon ( 3 );
                players[0].winPercentage = ((double)(players[0].getGamesWon ())/(double)(players[0].gamesPlayed))*100.0;


                players[1] = new NimPlayer ();
                players[1].setPlayer ( "jadams","Adams","John");
                players[1].gamesPlayed = 7;
                players[1].setGamesWon ( 7 );
                players[1].winPercentage = ((double)(players[1].getGamesWon ())/(double)(players[1].gamesPlayed))*100.0;

                players[2] = new NimPlayer ();
                players[2].setPlayer ( "tom","Jefferson","Thomas" );
                players[2].gamesPlayed = 4;
                players[2].setGamesWon ( 3 );
                players[2].winPercentage = ((double)(players[2].getGamesWon ())/(double)(players[2].gamesPlayed))*100.0;

               players[3] = new NimPlayer ();
                players[3].setPlayer ( "jmadison","Madison","James");
                players[3].gamesPlayed = 4;
                players[3].setGamesWon ( 3 );
                players[3].winPercentage = ((double)(players[3].getGamesWon ())/(double)(players[3].gamesPlayed))*100.0;

                players[4] = new NimPlayer ();
                players[4].setPlayer ( "jmonroe","Monroe","James"  );
                players[4].gamesPlayed = 4;
                players[4].setGamesWon ( 3 );
                players[4].winPercentage = ((double)(players[4].getGamesWon ())/(double)(players[4].gamesPlayed))*100.0;

                players[5] = new NimPlayer ();
                players[5].setPlayer ( "bob","boobsy","leo" );
                players[5].gamesPlayed = 3;
                players[5].setGamesWon ( 2 );
                players[5].winPercentage = ((double)(players[5].getGamesWon ())/(double)(players[5].gamesPlayed))*100.0;


                players[6] = new NimPlayer ();
                players[6].setPlayer ( "julz","Julio","Hulio");
                players[6].gamesPlayed = 7;
                players[6].setGamesWon ( 7 );
                players[6].winPercentage = ((double)(players[6].getGamesWon ())/(double)(players[6].gamesPlayed))*100.0;

                players[7] = new NimPlayer ();
                players[7].setPlayer ( "tim","Timothy","Thomas" );
                players[7].gamesPlayed = 4;
                players[7].setGamesWon ( 4 );
                players[7].winPercentage = ((double)(players[7].getGamesWon ())/(double)(players[7].gamesPlayed))*100.0;

                players[8] = new NimPlayer ();
                players[8].setPlayer ( "madi","Madison","O'Cloony");
                players[8].gamesPlayed = 4;
                players[8].setGamesWon ( 4 );
                players[8].winPercentage = ((double)(players[8].getGamesWon ())/(double)(players[8].gamesPlayed))*100.0;

                players[9] = new NimPlayer ();
                players[9].setPlayer ( "roe","Robin","Gregson"  );
                players[9].gamesPlayed = 4;
                players[9].setGamesWon ( 1 );
                players[9].winPercentage = ((double)(players[9].getGamesWon ())/(double)(players[9].gamesPlayed))*100.0;



                players[10] = new NimPlayer ();
                players[10].setPlayer ( "flnc","Falcon","Jerry");
                players[10].gamesPlayed = 7;
                players[10].setGamesWon(6);
                players[10].winPercentage = ((double)(players[10].getGamesWon ())/(double)(players[10].gamesPlayed))*100.0;

                players[11] = new NimPlayer ();
                players[11].setPlayer ( "hkl","Hulks","Banner" );
                players[11].gamesPlayed = 4;
                players[11].setGamesWon (4);
                players[11].winPercentage = ((double)(players[11].getGamesWon ())/(double)(players[11].gamesPlayed))*100.0;




                playerCounter = 12; */



        for (int k = 0; ; k++) {
            System.out.print ( "$" );


            function = keyboard.next ();


            if (function.equalsIgnoreCase ( addPlayer )) {

                userinput = keyboard.next ();

                String[] input = userinput.split ( "," );
                String username = input[0];
                String lastname = input[1];
                String firstname = input[2];

                playerCounter = addPlayer(players, username, lastname, firstname, playerCounter, maxPlayers);

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

                startGameFunction(players, keyboard, playerCounter, username1, username2, initialStones, upperBound);


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
                break;
            }
        }

    }


    static int addPlayer (NimPlayer[] players, String username, String lastname, String firstname, int playerCounter, int maxPlayers) {
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

    static boolean playerChecker(NimPlayer[] players, String username, int playerCounter) {
        for (int i = 0; i < playerCounter; i++) {
            if (players[i].getUserName ().equalsIgnoreCase ( username.replaceAll ( " ", "" ) )) {
                return true;
            }
        }
        return false;
    }

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
                        System.out.print ( players[k].gamesPlayed + " games," );
                        System.out.print ( players[k].getGamesWon () + " wins" );
                        System.out.print ( "\n" );
                    }
                }
            }
        }

        System.out.print ( "\n" );

    }

    static void displayPlayer(NimPlayer[] players, String username, int playercounter) {

        for (int i = 0; i < playercounter; i++) {
            if (players[i].getUserName ().equalsIgnoreCase ( username.replaceAll ( " ", "" ) )) {
                System.out.print (players[i].getUserName() + ",");
                System.out.print (players[i].getFirstName () + ",");
                System.out.print (players[i].getLastName () + ",");
                System.out.print (players[i].gamesPlayed + " games,");
                System.out.print (players[i].getGamesWon () + " wins");
                System.out.println ("\n");
                i++;
            }
        }
    }

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

    static void editPlayer(NimPlayer[] players, String username, String firstname, String lastname, int playerCounter) {
        int result = 0;
        for (int i = 0; i < playerCounter; i++) {
            if (players[i].getUserName ().equalsIgnoreCase ( username )) {
                players[i].setFirstAndLastNames ( firstname,lastname );
                break;
            }
        }
        System.out.print ("\n");
    }


    static void removePlayer(NimPlayer[] players, String username, int playerCounter) {
        String empty = "null";
        for (int i = 0; i < playerCounter; i++) {
            if (players[i].getUserName ().equalsIgnoreCase ( username.replaceAll ( " ", "" ) )) {
                players[i].setPlayer ( empty, empty, empty);
            }
        }
        System.out.print("\n");
    }

    static void removeAllPlayers(NimPlayer[] players, int playerCounter) {
        String empty = "null";
        for (int i = 0; i < playerCounter; i++) {
            players[i].setPlayer ( empty, empty, empty);
        }
        System.out.print ("\n");
    }

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

    static void resetAllStats(NimPlayer[] players, int playercounter) {
        for (int i = 0; i < playercounter; i++) {
            players[i].setGamesWon (0);
            players[i].gamesPlayed = 0;
        }
    }

    static void resetPlayerStats(NimPlayer[] players, String username, int playercounter) {
        for (int i = 0; i < playercounter; i++) {
            if (players[i].getUserName ().equalsIgnoreCase ( username.replaceAll ( " ", "" ) )) {
                players[i].gamesPlayed = 0;
                players[i].setGamesWon (0);
                break;
            }
        }
    }

    static void startGameFunction(NimPlayer[] players, Scanner keyboard, int playerCounter, String username1, String username2, int initialStones, int upperBound) {
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

        // PUT INTO ONE?

        if (player_check == 2) {

            int player1Index = retrievePlayerIndex ( players, username1, playerCounter );
            int player2Index = retrievePlayerIndex ( players, username2, playerCounter );

            System.out.println ( "\nInitial stone count: " + initialStones );
            System.out.println ( "Maximum stone removal: " + upperBound );
            System.out.println ( "Player 1: " + players[player1Index].getFirstName () + " " + players[player1Index].getLastName () );
            System.out.println ( "Player 2: " + players[player2Index].getFirstName () + " " + players[player2Index].getLastName () );


            NimGame newGame = new NimGame ();
            newGame.startNewGame ( initialStones, upperBound, player1Index, player2Index, keyboard, players );

            System.out.print ( "\n" );
            keyboard.nextLine ();
        }
    }

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

    static void rankingsAllPlayers(NimPlayer[] players, int playerCounter, String userInput) {
        int displayTen = 10;
        double[] playerWinPercentages = new double[playerCounter];

        if (playerCounter > displayTen){
            playerCounter = displayTen;
        }


        for (int i = 0; i < playerCounter; i++) {
            playerWinPercentages[i] = players[i].setWinPercentage ();
        }

        arrange ( playerWinPercentages, playerCounter );

        String[] playerUserNames = duplicateArrange (playerWinPercentages, playerCounter, players);
        int newLength = playerUserNames.length;

        rankingPrinter (playerUserNames, players, newLength, playerCounter, userInput);

    }



    static double[] arrange(double[] playerWinPercentages, int playerCounter) {

        int index = 0;
        double min = 0, tmp = 0;

        for (int i = 0; i < playerCounter; i++) {
            min = playerWinPercentages[i];

            for (int j = i; j < playerCounter; j++) {
                if (playerWinPercentages[j] <= min) {
                    min = playerWinPercentages[j];
                    index = j;
                }
            }

            tmp = playerWinPercentages[i];
            playerWinPercentages[i] = min;
            playerWinPercentages[index] = tmp;

        }

        return playerWinPercentages;

    }

    static String[] duplicateArrange(double[] playerWinPercentages, int playerCounter, NimPlayer[] players) {
        int duplicateCounter =0, indexPlayerNames=0, i=0;

        String[] playerUserNames = new String[playerCounter];

        while(i < playerCounter) {
            for(int j=0; j < playerCounter; j++) {
                if(playerWinPercentages[i] == playerWinPercentages[j]) {
                    duplicateCounter++;
                }
            }


            if(duplicateCounter == 1) {
                for(int k =0 ; k < playerCounter; k++) {
                    if(players[k].winPercentage == playerWinPercentages[i]) {
                        playerUserNames[indexPlayerNames] = players[k].getUserName ();
                        indexPlayerNames++;
                    }
                }

            } else {
                String[] duplicateNameSorted = nameSorter (playerWinPercentages[i], players, duplicateCounter, playerCounter);
                for(int l = 0; l < duplicateCounter; l++) {
                    playerUserNames[indexPlayerNames] = duplicateNameSorted[l];
                    indexPlayerNames++;
                }
            }

            i = i + duplicateCounter;
            duplicateCounter=0;
        }

        return playerUserNames;


    }

    static String[] nameSorter (double key, NimPlayer[] players, int duplicateCounterLength, int playerCounter) {
        String[] duplicateNames = new String[duplicateCounterLength];
        int indexDuplicateNames=0;

        for(int i=0; i <playerCounter; i++) {
            if(players[i].winPercentage == key) {
                duplicateNames[indexDuplicateNames] = players[i].getUserName ();
                indexDuplicateNames++;
            }
        }

        Arrays.sort ( duplicateNames );


        return duplicateNames;

    }



    static void rankingPrinter (String[] playerUserNames, NimPlayer[] players, int newLength, int playerCounter, String userInput) {
        String empty = "null";
        String order = userInput.replaceAll ( " ", "" );

        if (order.equalsIgnoreCase ( "desc" )) {
            for (int i = newLength - 1; i >= 0; i--) {
                for (int j = 0; j < playerCounter; j++) {
                    if (playerUserNames[i].equalsIgnoreCase ( players[j].getUserName () ) && !playerUserNames[i].equalsIgnoreCase ( empty )) {
                        playerRankFormatting ( players, j );

                    }
                }
            }
        } else if (order.equalsIgnoreCase ( "asc" )) {
            for (int i = 0; i < newLength; i++) {
                for (int j = 0; j < playerCounter; j++) {
                    if (playerUserNames[i].equalsIgnoreCase ( players[j].getUserName () ) && !playerUserNames[i].equalsIgnoreCase ( empty )) {
                        playerRankFormatting ( players, j );

                    }
                }
            }
        }

        System.out.print ("\n");

    }

    static void playerRankFormatting (NimPlayer[] players, int index) {

        String playerPercentageInner = String.format ( "%1.0f%%", players[index].winPercentage );
        String playerPercentageOuter = String.format ( "%-4s", playerPercentageInner );
        System.out.print ( playerPercentageOuter );
        System.out.print ( " | " );
        String playerGamesPlayedInner = String.format ( "%02d", players[index].gamesPlayed );
        String playerGamesPlayedOuter = String.format ( "%2s games ", playerGamesPlayedInner );
        System.out.print ( playerGamesPlayedOuter );
        System.out.print ( "| " );
        System.out.print ( players[index].getFirstName () + " " + players[index].getLastName () );
        System.out.print ( "\n" );
    }

}

