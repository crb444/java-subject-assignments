


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

    // DELETE THE FOLLOWING BEFORE SUBMISSION - they are used to enter data //

    public void setGamesPlayed(int GamesPlayed) {
        gamesPlayed = GamesPlayed;
    }

    public void setGamesWon(int GamesWon) {
        gamesWon = GamesWon;
    }

    public void SetWinPercentage (float gamesWon, float gamesPlayed) {

        winPercentage = ((gamesWon*100) / gamesPlayed);

    }
    public void setWinPercentage () {

        if (gamesWon == 0 || gamesPlayed == 0) {
            winPercentage = 0;
        } else {
            winPercentage = (gamesWon / gamesPlayed) * 100;
        }
    }
}







