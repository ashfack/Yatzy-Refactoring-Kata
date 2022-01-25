// This is one implementation of the Yatzy game https://en.wikipedia.org/wiki/Yahtzee
// Currently, we only handle the scoring part, we don't handle the dice rolls , nor the players 

public class Yatzy {

    private static final int MINIMAL_NUMBER = 1;
    private static final int MAXIMAL_NUMBER = 6;

    private static final int NB_ROLLS = 5;

    public static void checkValidity(int... dice) throws YatzyException {
        if (null == dice || dice.length != NB_ROLLS) {
            throw new YatzyException("The given roll does not contain the appropriate number ("
                    + NB_ROLLS + ")");
        }
        for (int die : dice) {
            if (MINIMAL_NUMBER > die || die > MAXIMAL_NUMBER) {
                throw new YatzyException(
                        "The numbers are not in appropriate range (" + MINIMAL_NUMBER + ", " + MAXIMAL_NUMBER + ")");
            }
        }
    }

    /**
     * 
     * @param dice
     * @param numberToCompare
     * @return the score for the given roll on the given category (number)
     * @throws YatzyException
     */
    private static int scoreCompteWithProvidedNumber(int[] dice, int numberToCompare) throws YatzyException {
        checkValidity(dice);

        int sum = 0;
        for (int die : dice) {
            if (numberToCompare == die) {
                sum += numberToCompare;
            }
        }
        return sum;
    }

    /**
     * 
     * @param dice
     * @return The sum of the dice that reads one
     * @throws YatzyException
     */
    public static int ones(int... dice) throws YatzyException {
        return scoreCompteWithProvidedNumber(dice, 1);
    }

    /**
     * 
     * @param dice
     * @return The sum of the dice that reads two
     * @throws YatzyException
     */
    public static int twos(int... dice) throws YatzyException {
        return scoreCompteWithProvidedNumber(dice, 2);
    }

    /**
     * 
     * @param dice
     * @return The sum of the dice that reads three
     * @throws YatzyException
     */
    public static int threes(int... dice) throws YatzyException {
        return scoreCompteWithProvidedNumber(dice, 3);
    }

    /**
     * 
     * @param dice
     * @return The sum of the dice that reads four
     * @throws YatzyException
     */
    public static int fours(int... dice) throws YatzyException {
        return scoreCompteWithProvidedNumber(dice, 4);
    }

    /**
     * 
     * @param dice
     * @return The sum of the dice that reads five
     * @throws YatzyException
     */
    public static int fives(int... dice) throws YatzyException {
        return scoreCompteWithProvidedNumber(dice, 5);
    }

    /**
     * 
     * @param dice
     * @return The sum of the dice that reads six
     * @throws YatzyException
     */
    public static int sixes(int... dice) throws YatzyException {
        return scoreCompteWithProvidedNumber(dice, 6);
    }

    /**
     * 
     * @param dice
     * @return The sum of all dices
     * @throws YatzyException
     */
    public static int chance(int... dice) throws YatzyException {
        checkValidity(dice);
        int sum = 0;
        for (int die : dice) {
            sum += die;
        }
        return sum;
    }

    /**
     * 
     * @param dice
     * @return in the output array, array[x] contains the frequency of number x+1 in
     *         the given dice roll
     * @throws YatzyException
     */
    private static int[] generateFrequencyArray(int... dice) throws YatzyException {
        checkValidity(dice);
        int[] frequencyArray = new int[MAXIMAL_NUMBER - MINIMAL_NUMBER + 1];
        for (int die : dice) {
            frequencyArray[die - 1]++;
        }
        return frequencyArray;
    }

    /**
     * 
     * @param dice
     * @return 50 if all numbers are same, 0 otherwise
     * @throws YatzyException
     */
    public static int yatzyGame(int... dice) throws YatzyException {
        checkValidity(dice);
        int[] frequencyArray = generateFrequencyArray(dice);
        for (int frequency : frequencyArray) {
            if (frequency != 0 && frequency != dice.length) {
                return 0;
            }
        }
        return 50;
    }

    /**
     * 
     * @param dice
     * @return the double of the highest digit if present at least twice, otherwise
     *         0
     * @throws YatzyException
     */
    public static int highestPair(int... dice) throws YatzyException {
        checkValidity(dice);
        int[] frequencyArray = generateFrequencyArray(dice);
        for (int index = MAXIMAL_NUMBER - 1; index >= MINIMAL_NUMBER - 1; index--) {
            if (2 <= frequencyArray[index]) {
                return (index + 1) * 2;
            }
        }
        return 0;
    }

    /**
     * 
     * @param dice
     * @return the highest two pairs double, otherwise 0
     * @throws YatzyException
     */
    public static int highestTwoPairs(int... dice) throws YatzyException {
        checkValidity(dice);
        int[] frequencyArray = generateFrequencyArray(dice);
        int n = 0;
        int score = 0;

        for (int index = MAXIMAL_NUMBER - 1; index >= MINIMAL_NUMBER - 1; index--) {
            if (2 <= frequencyArray[index]) {
                n++;
                score += (index + 1) * 2;
            }
        }
        if (n == 2) {
            return score;
        } else {
            return 0;
        }
    }

    /**
     * 
     * @param frequencyArray
     * @param n              : the number of elements we want of the same kind
     * @return
     */
    private static int nOfAKind(int[] frequencyArray, int n) {
        for (int index = MAXIMAL_NUMBER - 1; index >= MINIMAL_NUMBER - 1; index--) {
            if (n <= frequencyArray[index]) {
                return (index + 1) * n;
            }
        }
        return 0;
    }

    /**
     * 
     * @param dice
     * @return if at least one number is present thrice then the triple of the
     *         number, otherwise 0
     * @throws YatzyException
     */
    public static int threeOfAKind(int... dice) throws YatzyException {
        checkValidity(dice);
        int[] frequencyArray = generateFrequencyArray(dice);

        return nOfAKind(frequencyArray, 3);
    }

    /**
     * 
     * @param dice
     * @return if at least one number is present four times then the quadruple of
     *         the number, otherwise 0
     * @throws YatzyException
     */
    public static int fourOfAKind(int... dice) throws YatzyException {
        checkValidity(dice);
        int[] frequencyArray = generateFrequencyArray(dice);

        return nOfAKind(frequencyArray, 4);
    }

    /**
     * 
     * @param dice
     * @return If all numbers between one and five are present (and only once) (no
     *         matter the order) then 15, otherwise 0
     * @throws YatzyException
     */
    public static int smallStraight(int... dice) throws YatzyException {
        checkValidity(dice);
        int[] frequencyArray = generateFrequencyArray(dice);
        for (int index = MINIMAL_NUMBER - 1; index < MAXIMAL_NUMBER - 1; index++) {
            if (1 != frequencyArray[index]) {
                return 0;
            }
        }
        return chance(dice); // We could return 15 directly or [(5 * 6) - (0 * 1 )] / 2
    }

    /**
     * 
     * @param dice
     * @return If all numbers between two and six are present (and only once) (no
     *         matter the order) then 20, otherwise 0
     * @throws YatzyException
     */
    public static int largeStraight(int... dice) throws YatzyException {
        checkValidity(dice);
        int[] frequencyArray = generateFrequencyArray(dice);
        for (int index = MINIMAL_NUMBER; index < MAXIMAL_NUMBER; index++) {
            if (1 != frequencyArray[index]) {
                return 0;
            }
        }
        return chance(dice); // We could return 15 directly or [(6 * 7) - (1 * 2)] / 2
    }

    /**
     * 
     * @param dice
     * @return If the dice are two of a kind and three of a kind then the player
     *         scores the sum of all the dice
     * @throws YatzyException
     */
    public static int fullHouse(int... dice) throws YatzyException {
        checkValidity(dice);
        int[] frequencyArray = generateFrequencyArray(dice);
        boolean hasExactly2 = false;
        boolean hasExactly3 = false;

        for (int index = MINIMAL_NUMBER; index < MAXIMAL_NUMBER; index++) {
            if (2 == frequencyArray[index]) {
                hasExactly2 = true;
            } else if (3 == frequencyArray[index]) {
                hasExactly3 = true;
            }
        }

        if (hasExactly2 && hasExactly3) {
            return chance(dice); // We could have computed the score on the go
        } else {
            return 0;
        }
    }
}
