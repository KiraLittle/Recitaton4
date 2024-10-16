import java.util.Random;

public class RPS_Player {
    private int numberOfGamesWon;
    private int numberOfGamesPlayed;
    private int choice;
    private int aPlayer;
    private String name;
    private Random rand = new Random();

    public RPS_Player(String name){
        this.name = name;
        // TODO: replace this line with your code.

    }

    public String getName(){
        // TODO: replace this line with your code.
        return name;
    }

    /**
     * Returns the number of games played since a clear() was issued.
     * @return returns the number of games played.
     */
    public int getNumberOfGamesPlayed(){
        // TODO: replace this line with your code.
        return numberOfGamesPlayed;
    }

    /**
     * Returns the number of games won since a clear() was issued.
     * @return returns the number of games won.
     */
    public int getNumberOfGamesWon(){
        // TODO: replace this line with your code.
        return numberOfGamesWon;
    }

    /**
     * Returns the win percentage as number between 0 and 1.
     * @return win percentage as a double.
     */
    public double getWinPercentage(){
        // TODO: replace this line with your code.
        return ((double)getNumberOfGamesWon()/getNumberOfGamesPlayed());
    }

    /**
     * Starts a new game.
     */
    public void clear(){
        // TODO: replace this line with your code.
        numberOfGamesWon = 0;
        numberOfGamesPlayed = 0;
    }

    /**
     * This player challenges anotherPlayer whereby both players make a
     * random choice of rock, paper, scissors.  A reference to the winning
     * player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player challenge(RPS_Player anotherPlayer) {

        // 1- ROCK  2- PAPER   3- SCISSORS

        //player 1

        choice = rand.nextInt(3) + 1;

        //player 2

        aPlayer = rand.nextInt(3) + 1;


        if ((((choice == 1) && (aPlayer == 3)) || ((choice == 2) && (aPlayer == 1))) || ((choice == 3) && (aPlayer == 2))) {
            System.out.println("Player 1 Wins!");
            numberOfGamesWon += 1;
            numberOfGamesPlayed += 1;
            anotherPlayer.numberOfGamesPlayed +=1;
            return this;
        } else if ((((aPlayer == 1) && (choice == 3)) || ((aPlayer == 2) && (choice == 1))) || ((aPlayer == 3) && (choice == 2))) {
            System.out.println("Player 2 Wins!");
            numberOfGamesPlayed += 1;
            anotherPlayer.numberOfGamesWon+=1;
            anotherPlayer.numberOfGamesPlayed +=1;
            return anotherPlayer;
        } else if (aPlayer == choice) {
            numberOfGamesPlayed += 1;
            anotherPlayer.numberOfGamesPlayed +=1;
            return null;
        }

        if (anotherPlayer.numberOfGamesPlayed<numberOfGamesWon ) {
            System.out.println("Player 1 Wins!");
            return this;
            } else if(anotherPlayer.numberOfGamesWon== numberOfGamesWon) {
                System.out.println("Tie!!");
                return null;
            }else{
            System.out.println("Player 2 Wins!");
            return anotherPlayer;

        }

    }


    /**
     * This player challenges anotherPlayer whereby this player uses the previous
     * choice made and anotherPlayer makes a random choice of rock, paper, scissors.
     * A reference to the winning player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */

    public RPS_Player keepAndChallenge(RPS_Player anotherPlayer){
        // TODO: same as challenge but no op

        // 1- ROCK  2- PAPER   3- SCISSORS

        //player 2
        aPlayer = rand.nextInt(3)+1;

        //number of games player 2 won
        if ((((choice == 1) && (aPlayer == 3)) || ((choice == 2) && (aPlayer == 1))) || ((choice == 3) && (aPlayer == 2))) {
            System.out.println("Player 1 Wins!");
            numberOfGamesWon += 1;
            numberOfGamesPlayed += 1;
            anotherPlayer.numberOfGamesPlayed +=1;
            return this;
        } else if ((((aPlayer == 1) && (choice == 3)) || ((aPlayer == 2) && (choice == 1))) || ((aPlayer == 3) && (choice == 2))) {
            System.out.println("Player 2 Wins!");
            numberOfGamesPlayed += 1;
            anotherPlayer.numberOfGamesWon+=1;
            anotherPlayer.numberOfGamesPlayed +=1;
            return anotherPlayer;
        } else if (aPlayer == choice) {
            numberOfGamesPlayed += 1;
            anotherPlayer.numberOfGamesPlayed +=1;
            return null;
        }

        if (anotherPlayer.numberOfGamesPlayed<numberOfGamesWon ) {
            System.out.println("Player 1 Wins!");
            return this;
        } else if(anotherPlayer.numberOfGamesWon== numberOfGamesWon) {
            System.out.println("Tie!!");
            return null;
        }else{
            System.out.println("Player 2 Wins!");
            return anotherPlayer;


        }

    }


}
