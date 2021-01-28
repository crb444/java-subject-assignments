
/**
 * The NimPlayer class sets the attributes for the NimPlayer objects. Additionally, the following
 * methods have the purpose of returning the private attributes, whilst also setting them to a
 * particular value that the user has specified.
 *
 */


public class NimPlayer {
    private String userName, firstName, lastName;
    private float winPercentage;
    private int gamesWon, gamesPlayed;

    public NimPlayer() {
        gamesPlayed = 0;
        gamesWon = 0;
        winPercentage = 0;
    }

    public void setPlayer(String username, String firstname, String lastname) {
        userName = username;
        firstName = firstname;
        lastName = lastname;
    }

    public void setFirstAndLastNames(String firstname, String lastname) {
        firstName = firstname;
        lastName = lastname;
    }

    public void resetGamesWon() {
        gamesWon = 0;
    }

    public void setWonGame() {
        gamesWon = gamesWon + 1;
    }

    public void setGamesPlayed() {
        gamesPlayed = gamesPlayed + 1;
    }

    public void resetGamesPlayed() {
        gamesPlayed = 0;
    }


    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    /* The following method calculates the win percentage of the player, but returns 0 when
    * either the games won or games played attribute is 0. This prevents any issues the
    * program will face with arithmetic based on dividing by zero.
    *
     */


    public double calculateWinPercentage () {

        if (gamesWon == 0 || gamesPlayed == 0) {
            return  0;
        } else {
            return winPercentage = ((gamesWon*100) / gamesPlayed);
        }
    }

    public double getWinPercentage() {
        return winPercentage;
    }

}







