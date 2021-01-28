import java.util.Arrays;


public class NimPlayer {
    String userName, firstName, lastName;
    int gamesPlayed, gamesWon;
    double winPercentage;

    public NimPlayer (){
        gamesPlayed = 0;
        gamesWon = 0;
        winPercentage = 0;
    }

    int playerChecker(NimPlayer[] players, String username, int playerCounter) {
        int result = 0;
        for (int i = 0; i < playerCounter; i++) {
            if (players[i].userName.equalsIgnoreCase ( username.replaceAll ( " ","" ) )) {
                result = 1;
                break;
            } else {
                result = 2;
            }
        }
        return result;
    }

    int retrievePlayerIndex(NimPlayer[] players, String userName, int playerCounter) {
        int index = 0;
        for(int i=0; i < playerCounter; i++) {
            if(players[i].userName.equalsIgnoreCase ( userName.replaceAll ( " ","" ) )) {
                index = i;
                break;
            }
        }
        return index;
    }

    int addPlayer(NimPlayer[] players, String username, String firstname, String lastname, int playerCounter) {
        players[playerCounter] = new NimPlayer ();
        players[playerCounter].userName = username;
        players[playerCounter].firstName = firstname;
        players[playerCounter].lastName = lastname;
        playerCounter++;
        return playerCounter;
    }

    void removePlayer(NimPlayer[] players, String username, int playerCounter) {
        for (int i = 0; i < playerCounter; i++) {
            if(players[i].userName.equalsIgnoreCase ( username.replaceAll ( " ","" ) )) {
                players[i].userName = "null";
                players[i].firstName = "null";
                players[i].lastName = "null";
            }
        }
    }

    void removeAllPlayers(NimPlayer[] players, int playerCounter) {
        for (int i = 0; i < playerCounter; i++) {
            players[i].userName = "null";
            players[i].firstName = "null";
            players[i].lastName = "null";
        }
    }

    void displayAllPlayers(NimPlayer[] players, int playerCounter) {
        int i=0;
        String empty = "null";

        while (i < playerCounter) {
            if (players[i].userName.equalsIgnoreCase ( empty )) {
                i++;
            } else {

                System.out.print ( "\n" );
                System.out.print ( "Username:" + players[i].userName + " " );
                System.out.print ( "Name:" + players[i].firstName + " " );
                System.out.print ( "Last Name:" + players[i].lastName + " " );
                System.out.print ( "Games played:" + players[i].gamesPlayed + " " );
                System.out.print ( "Games won:" + players[i].gamesWon + " " );
                System.out.print ( "\n" );
                i++;
            }
        }
        System.out.print("\n");

    }

    /*

    void rankingsAllPlayers(NimPlayer[] players, int playerCounter) {
        double[] temporary = new double[50];


        for(int i=0; i<playerCounter; i++) {
            temporary[i] = players[i].winPercentage;
        }


        rankingAsc (temporary, playerCounter );

        rankingPrinter ( temporary, players, playerCounter );




        for(int i=0; i<playerCounter; i++) {
            System.out.print(temporary[i]);
            System.out.print("\n");
        }



    }

    void rankingAsc(double[] temporary, int playerCounter) {
        double minimumScore = 0, tmp=0;
        int indexValue =0, index_counter=0;
        int[] indexes = new int[50];


        for(int i=0; i < playerCounter; i++) {
            minimumScore = temporary[i];

            for (int j = i; j < playerCounter; j++) {

                if (temporary[j] <= minimumScore) {
                    minimumScore = temporary[j];
                    indexValue = j;
                }
            }

            tmp = temporary[i];
            temporary[i] = minimumScore;
            temporary[indexValue] = tmp;
        }

    }

    void rankingPrinter(double[] temporary, NimPlayer[] players, int playerCounter) {

        String percentage = "%";
        String line = "|";
        int count =0, match=0;


        for(int i=0; i < playerCounter; i++) {
            for(int j=0; j < playerCounter; j++) {
                if(temporary[i] == players[j].winPercentage) {
                    match = j;
                    count++;
                }
            }

            if(count == 1) {
                String playerPercentageInner = String.format ("%1.0f%%", players[match].winPercentage);
                String playerPercentageOuter = String.format("%-6s",playerPercentageInner);
                System.out.print(playerPercentageOuter);
                System.out.print("|");
                System.out.printf(" %02d games  ", players[match].gamesPlayed);
                System.out.printf("%-4s", line);
                System.out.print(players[match].firstName + " " + players[match].lastName);
                System.out.print("\n");
            } else {

            }

        }
    }
    */

    void displayPlayer(NimPlayer[] players, String username, int playercounter) {
        for(int i=0; i<playercounter ; i++) {
            if(players[i].userName.equalsIgnoreCase ( username.replaceAll ( " ","" ) )) {
                System.out.print ( "\n" );
                System.out.print ( "Username:" + players[i].userName + " " );
                System.out.print ( "Name:" + players[i].firstName + " " );
                System.out.print ( "Last Name:" + players[i].lastName + " " );
                System.out.print ( "Games played:" + players[i].gamesPlayed + " " );
                System.out.print ( "Games won:" + players[i].gamesWon + " " );
                System.out.print ( "\n" );
            }
        }
    }

    void editPlayer(NimPlayer[] players, String firstname, String lastname, int playerCounter) {
        int result=0;
        for (int i = 0; i < playerCounter; i++) {
            if (players[i].firstName.equalsIgnoreCase ( firstname ) ||
                    players[i].lastName.equalsIgnoreCase ( lastname )) {
                players[i].firstName = firstname;
                players[i].lastName = lastname;
                result = 1;
                break;
            }
        }
        if(result==0) {
            System.out.print ( "Player does not exist!" );
        }
    }

    void resetAllStats (NimPlayer[] players, int playercounter) {
        for(int i=0; i<playercounter; i++) {
            players[i].gamesWon = 0;
            players[i].gamesPlayed =0;
        }
    }

    void resetPlayerStats(NimPlayer[] players, String username, int playercounter) {
        for(int i=0; i<playercounter; i++) {
            if(players[i].userName.equalsIgnoreCase ( username.replaceAll ( " ","" ) )) {
                players[i].gamesPlayed =0;
                players[i].gamesWon =0;
                break;
            }
        }
    }


    public int removeStone (int stones, int removeStones, int upperBound) {
        if (removeStones > upperBound) {
            System.out.println("\nPlease enter a value within the bounds.");
        } else {
            stones = stones - removeStones;
        }
        return stones;
    }



    public int playAgain (String response) {
        String no = "N";
        String yes = "Y";

        if (no.equalsIgnoreCase ( response )) {
            System.exit ( 0 );
            return 0;
        } else if (yes.equalsIgnoreCase ( response )) {
            return 1;
        } else {
            return 2;
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

    void rankingsAllPlayers(NimPlayer[] players, int playerCounter) {
        double[] playerWinPercentages = new double[playerCounter];


        for (int i = 0; i < playerCounter; i++) {
            playerWinPercentages[i] = players[i].winPercentage;
        }

        arrange ( playerWinPercentages, playerCounter );

        for (int i = 0; i < playerCounter; i++) {
            System.out.print ( playerWinPercentages[i] + "\n" );
        }
        System.out.print ( "\n" );

        duplicateTester ( playerWinPercentages, playerCounter, players );
    }


        void  arrange(double[] playerWinPercentages, int length) {

        double min = 0, tmp =0;
                int index=0, duplicates=0;

        for(int i=0; i < length ; i++) {
            min = playerWinPercentages[i];

            for(int j=i; j < length ; j++) {
                if(playerWinPercentages[j] <= min) {
                    min = playerWinPercentages[j];
                    index = j;
                }
            }

            tmp = playerWinPercentages[i];
            playerWinPercentages[i] = min;
            playerWinPercentages[index] = tmp;

        }

    }

    void duplicateTester(double[] playerWinPercentages, int length, NimPlayer[] players) {
        int duplicates = 0, newIndex = 0;
        double duplicateEntity = 0, value=0;

        for (int i = 0; i < length; i++) {


            for (int j = i+1; j < length; j++) {
                if (playerWinPercentages[j] == playerWinPercentages[i]) {
                    duplicates++;
                    duplicateEntity = playerWinPercentages[i];

                }
            }

            if (duplicates >= 1) {
                newIndex = sortDuplicates ( playerWinPercentages, length, players, duplicateEntity );
                duplicates =0;
                duplicateEntity =0;
                i=i+(newIndex-1);
            } else {
                value= playerWinPercentages[i];
                printer (players, value, length );
            }

        }

    }

    int sortDuplicates(double[] playerWinPercentages, int length, NimPlayer[] players, double duplicateEntity) {
        String[] names = new String[6];
        int marker=0;

        for(int i=0; i < length; i++) {
            if(duplicateEntity == players[i].winPercentage) {
                names[marker] = players[i].firstName;
                marker++;
            }
        }

        Arrays.sort(names, 0 , marker);

        for(int i=0; i < marker; i++) {
            System.out.print ( "\n" );
            System.out.println(names[i]);
        }

        return marker;

    }

    void printer(NimPlayer[] players, double value, int length) {


        for(int i=0; i < length; i++) {
            if(value == players[i].winPercentage) {
                System.out.print(players[i].firstName + "\n");
                break;
            }
        }

    }
}
