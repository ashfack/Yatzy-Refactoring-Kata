import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void checkValidity() throws YatzyException {
        int[] smallerDiceRoll = { 1, 2, 3, 4 };
        // Smaller roll
        assertThrows(YatzyException.class, () -> {
            Yatzy.checkValidity(smallerDiceRoll);
        });
        // Bigger roll
        int[] biggerDiceRoll = { 1, 2, 3, 4, 5, 6 };
        assertThrows(YatzyException.class, () -> {
            Yatzy.checkValidity(biggerDiceRoll);
        });

        // Smaller bound
        assertThrows(YatzyException.class, () -> {
            Yatzy.checkValidity(6, 5, 4, 3, 0);
        });
        // Higher bound
        assertThrows(YatzyException.class, () -> {
            Yatzy.checkValidity(6, 7, 4, 3, 1);
        });

    }

    /**
     * The following 6 methods test the score of the sum of the dice that reads one,
     * two, three, four, five or six, respectively.
     * 
     * @throws YatzyException
     */

    @Test
    public void ones() throws YatzyException {
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
        assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
    }

    @Test
    public void twos() throws YatzyException {
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
    }

    @Test
    public void threes() throws YatzyException {
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
    }

    @Test
    public void fours() throws YatzyException {
        assertEquals(4, Yatzy.fours(4, 5, 5, 5, 5));
        assertEquals(8, Yatzy.fours(4, 4, 5, 5, 5));
        assertEquals(12, Yatzy.fours(4, 4, 4, 5, 5));
    }

    @Test
    public void fives() throws YatzyException {
        assertEquals(10, Yatzy.fives(4, 4, 4, 5, 5));
        assertEquals(15, Yatzy.fives(4, 4, 5, 5, 5));
        assertEquals(20, Yatzy.fives(4, 5, 5, 5, 5));
    }

    @Test
    public void sixes() throws YatzyException {
        assertEquals(0, Yatzy.sixes(4, 4, 4, 5, 5));
        assertEquals(6, Yatzy.sixes(4, 4, 6, 5, 5));
        assertEquals(18, Yatzy.sixes(6, 5, 6, 6, 5));
    }

    /**
     * Test the method chance that adds all numbers
     * 
     * @throws YatzyException
     */
    @Test
    public void chance() throws YatzyException {
        assertEquals(15, Yatzy.chance(2, 3, 4, 5, 1));
        assertEquals(16, Yatzy.chance(3, 3, 4, 5, 1));
    }

    /**
     * 50 if all numbers are same, 0 otherwise
     * 
     * @throws YatzyException
     */
    @Test
    public void yatzy_scores_50() throws YatzyException {
        assertEquals(0, Yatzy.yatzyGame(6, 6, 6, 6, 3));
        assertEquals(50, Yatzy.yatzyGame(4, 4, 4, 4, 4));
        assertEquals(50, Yatzy.yatzyGame(6, 6, 6, 6, 6));
    }

    /**
     * the double of the highest digit if present at least twice, otherwise 0
     * 
     * @throws YatzyException
     */
    @Test
    public void highestPair() throws YatzyException {
        assertEquals(0, Yatzy.highestPair(5, 3, 6, 4, 1));
        assertEquals(4, Yatzy.highestPair(1, 1, 3, 2, 2));
        assertEquals(6, Yatzy.highestPair(3, 4, 3, 5, 6));
        assertEquals(10, Yatzy.highestPair(5, 3, 3, 3, 5));
        assertEquals(12, Yatzy.highestPair(5, 3, 6, 6, 5));
    }

    /**
     * the highest two pairs double, otherwise 0
     * 
     * @throws YatzyException
     */
    @Test
    public void highestTwoPairs() throws YatzyException {
        assertEquals(12, Yatzy.highestTwoPairs(1, 1, 5, 4, 5));
        assertEquals(16, Yatzy.highestTwoPairs(3, 3, 5, 4, 5));
        assertEquals(16, Yatzy.highestTwoPairs(3, 3, 5, 5, 5));
    }

    /**
     * if at least one number is present thrice then the triple of the number,
     * otherwise 0
     * 
     * @throws YatzyException
     */
    @Test
    public void threeOfAKind() throws YatzyException {
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 4, 5));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 5));
        assertEquals(15, Yatzy.threeOfAKind(5, 3, 5, 4, 5));
    }

    /**
     * if at least one number is present four times then the quadruple of the
     * number, otherwise 0
     * 
     * @throws YatzyException
     */
    @Test
    public void fourOfAKind() throws YatzyException {
        assertEquals(12, Yatzy.fourOfAKind(3, 3, 3, 3, 5));
        assertEquals(12, Yatzy.fourOfAKind(3, 3, 3, 3, 3));
        assertEquals(20, Yatzy.fourOfAKind(5, 5, 5, 4, 5));
    }

    /**
     * If all numbers between one and five are present (and only once) (no matter
     * the order) then 15, otherwise 0
     * 
     * @throws YatzyException
     */
    @Test
    public void smallStraight() throws YatzyException {
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
        assertEquals(0, Yatzy.smallStraight(1, 2, 3, 4, 6));
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
    }

    /**
     * If all numbers between two and six are present (and only once) (no matter the
     * order) then 20, otherwise 0
     * 
     * @throws YatzyException
     */
    @Test
    public void largeStraight() throws YatzyException {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    /**
     * If the dice are two of a kind and three of a kind, the player scores the sum
     * of all the dice
     * 
     * @throws YatzyException
     */
    @Test
    public void fullHouse() throws YatzyException {
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.fullHouse(2, 2, 2, 2, 2));
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
    }
}
