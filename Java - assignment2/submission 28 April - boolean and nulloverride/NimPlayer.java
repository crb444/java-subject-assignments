


public class NimPlayer {
    private String userName, firstName, lastName;
    int gamesPlayed;
    double winPercentage;
    private int gamesWon;

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

    public void setGamesWon(int value) {
        gamesWon = value;
    }

    public void setWonGame() {
        gamesWon = gamesWon + 1;
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

    public double setWinPercentage () {

        if (gamesWon == 0 || gamesPlayed == 0) {
            return 0;
        } else {
            winPercentage = (gamesWon / gamesPlayed) * 100;
            return winPercentage;
        }
    }
}







