import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    /**
     * The following 6 methods test the score of the sum of the dice that reads one,
     * two, three, four, five or six, respectively.
     */

    @Test
    public void ones() {
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
        assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
    }

    @Test
    public void twos() {
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
    }

    @Test
    public void threes() {
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
    }

    @Test
    public void fours() {
        assertEquals(4, Yatzy.fours(4, 5, 5, 5, 5));
        assertEquals(8, Yatzy.fours(4, 4, 5, 5, 5));
        assertEquals(12, Yatzy.fours(4, 4, 4, 5, 5));
    }

    @Test
    public void fives() {
        assertEquals(10, Yatzy.fives(4, 4, 4, 5, 5));
        assertEquals(15, Yatzy.fives(4, 4, 5, 5, 5));
        assertEquals(20, Yatzy.fives(4, 5, 5, 5, 5));
    }

    @Test
    public void sixes() {
        assertEquals(0, Yatzy.sixes(4, 4, 4, 5, 5));
        assertEquals(6, Yatzy.sixes(4, 4, 6, 5, 5));
        assertEquals(18, Yatzy.sixes(6, 5, 6, 6, 5));
    }

    /**
     * Test the method chance that adds all numbers
     */
    @Test
    public void chance() {
        assertEquals(15, Yatzy.chance(2, 3, 4, 5, 1));
        assertEquals(16, Yatzy.chance(3, 3, 4, 5, 1));
    }

    /**
     * 50 if all numbers are same, 0 otherwise
     */
    @Test
    public void yatzy_scores_50() {
        assertEquals(0, Yatzy.yatzyGame(6, 6, 6, 6, 3));
        assertEquals(50, Yatzy.yatzyGame(4, 4, 4, 4, 4));
        assertEquals(50, Yatzy.yatzyGame(6, 6, 6, 6, 6));
    }

    /**
     * the double of the highest digit if present at least twice, otherwise 0
     */
    @Test
    public void highestPair() {
        assertEquals(0, Yatzy.highestPair(5, 3, 6, 4, 1));
        assertEquals(4, Yatzy.highestPair(1, 1, 3, 2, 2));
        assertEquals(6, Yatzy.highestPair(3, 4, 3, 5, 6));
        assertEquals(10, Yatzy.highestPair(5, 3, 3, 3, 5));
        assertEquals(12, Yatzy.highestPair(5, 3, 6, 6, 5));
    }

    /**
     * the highest two pairs double, otherwise 0
     */
    @Test
    public void highestTwoPairs() {
        assertEquals(12, Yatzy.highestTwoPairs(1, 1, 5, 4, 5));
        assertEquals(16, Yatzy.highestTwoPairs(3, 3, 5, 4, 5));
        assertEquals(16, Yatzy.highestTwoPairs(3, 3, 5, 5, 5));
    }

    /**
     * if at least one number is present thrice then the triple of the number, otherwise 0
     */
    @Test
    public void threeOfAKind() {
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 4, 5));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 5));
        assertEquals(15, Yatzy.threeOfAKind(5, 3, 5, 4, 5));
    }

    /** if at least one number is present four times then the quadruple of the number, otherwise 0 */
    @Test
    public void fourOfAKind() {
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 3));
        assertEquals(12, Yatzy.fourOfAKind(3, 3, 3, 3, 5));
        assertEquals(20, Yatzy.fourOfAKind(5, 5, 5, 4, 5));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }
}
