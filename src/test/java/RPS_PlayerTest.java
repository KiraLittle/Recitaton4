import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

class RPS_PlayerTest {

    RPS_Player player1;
    RPS_Player player2;
    RPS_Player player3;

    public RPS_PlayerTest(){

    }

    @BeforeEach
    void createPlayers()
    {
        player1 = new RPS_Player("P1");
        player2 = new RPS_Player("P2");
        player3 = new RPS_Player("P3");
    }

    @Test
    @DisplayName("[1] test getNumberOfGamesPlayed")
    void getNumberOfGamesPlayed() {
        Random rand = new Random();
        int expected = rand.nextInt(20);
        for(int i=0; i < expected; i++){
            player1.challenge(player2);
            player2.challenge(player3);
            player3.challenge(player1);
        }
        assertEquals(2*expected,player1.getNumberOfGamesPlayed());
        assertEquals(2*expected,player2.getNumberOfGamesPlayed());
        assertEquals(2*expected,player3.getNumberOfGamesPlayed());
    }

    @Test
    @DisplayName("[1] test getName")
    void getName() {
        assertEquals("P1", player1.getName());
        assertEquals("P2", player2.getName());
        assertEquals("P3", player3.getName());
    }

    @Test
    @DisplayName("[1] test getNumberOfGamesWon")
    void getNumberOfGamesWon() {
        int p1Expected = 0;
        int p2Expected = 0;

        for(int i=0; i < 50; i++){
            RPS_Player winner = player1.challenge(player2);
            if (winner == player1){
                p1Expected += 1;
            }else if (winner == player2){
                p2Expected +=1;
            }
        }
        assertEquals(p1Expected,player1.getNumberOfGamesWon());
        assertEquals(p2Expected,player2.getNumberOfGamesWon());
    }

    @Test
    @DisplayName("[1] test getWinPercentage")
    void getWinPercentage() {
        int p1Expected = 0;
        int p2Expected = 0;
        for(int i=0; i < 50; i++){
            RPS_Player winner = player1.challenge(player2);
            if (winner == player1){
                p1Expected += 1;
            }else if (winner == player2){
                p2Expected +=1;
            }
        }
        assertEquals(p1Expected/50.0,player1.getWinPercentage());
        assertEquals(p2Expected/50.0,player2.getWinPercentage());
    }

    @Test
    @DisplayName("[3] test clear")
    void clear() {
        for(int i=0; i < 50; i++){
            player1.challenge(player2);
            player2.challenge(player3);
            player3.challenge(player1);
        }
        player1.clear();
        player2.clear();
        player3.clear();
        assertEquals(0,player1.getNumberOfGamesPlayed());
        assertEquals(0,player2.getNumberOfGamesPlayed());
        assertEquals(0,player3.getNumberOfGamesPlayed());
        assertEquals(0,player1.getNumberOfGamesWon());
        assertEquals(0,player2.getNumberOfGamesWon());
        assertEquals(0,player3.getNumberOfGamesWon());
    }

    @Test
    @DisplayName("[6] test challenge")
    void challenge() {
        int p1Expected = 0;
        int p2Expected = 0;
        for(int i=0; i < 50; i++){
            RPS_Player winner = player1.challenge(player2);
            if (winner == player1){
                p1Expected += 1;
            }else if (winner == player2){
                p2Expected +=1;
            }
        }
        assertEquals(p1Expected,player1.getNumberOfGamesWon());
        assertEquals(p2Expected,player2.getNumberOfGamesWon());
    }

    @Test
    @DisplayName("[6] test keepAndChallenge")
    void keepAndChallenge() {
        int p1Expected = 0;
        int p2Expected = 0;
        for(int i=0; i < 50; i++){
            RPS_Player winner = player1.keepAndChallenge(player2);
            if (winner == player1){
                p1Expected += 1;
            }else if (winner == player2){
                p2Expected +=1;
            }
        }
        assertEquals(p1Expected,player1.getNumberOfGamesWon());
        assertEquals(p2Expected,player2.getNumberOfGamesWon());
    }
}