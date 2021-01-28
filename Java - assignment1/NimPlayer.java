
public class NimPlayer {
    public String name, response;

    /* The method below takes the player input during their turn and determines if they entered a
    value within the bounds. If not, the message below is printed and they are asked again to enter
    a value of stones to remove.
     */

    public int removeStone (int stones, int removeStones, int upperBound) {
        if (removeStones > upperBound) {
            System.out.println("\nPlease enter a value within the bounds.");
        } else {
            stones = stones - removeStones;
        }
        return stones;
    }

    /* This method determines whether another round of the game will be played. The user inputs a
    value and that value is compared with the two strings that are declared. Depending on what the
    user inputs, a certain value is returned, which correlates to a particular action in the
    Nimsys class.
    */

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

    /* The method below prints the number of stones that are present at the beginning of the game
    and at the end of each user turn.
     */

    public void stonePrinter (int stones) {
        for (int i = 0; i < stones; i++) {
            if(i == stones -1 ) {
                System.out.print ("*");
            } else {
                System.out.print ("* ");
            }
        }
    }
}
