public class Yatzy {
    private static final int MINIMAL_NUMBER = 1;
    private static final int MAXIMAL_NUMBER = 6;

    /**
     * 
     * @param dice
     * @return The sum of the dice that reads one
     */
    public static int ones(int... dice) {
        int sum = 0;
        int numberToCompare = 1;
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
     * @return The sum of the dice that reads two
     */
    public static int twos(int... dice) {
        int sum = 0;
        int numberToCompare = 2;
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
     * @return The sum of the dice that reads three
     */
    public static int threes(int... dice) {
        int sum = 0;
        int numberToCompare = 3;
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
     * @return The sum of the dice that reads four
     */
    public static int fours(int... dice) {
        int sum = 0;
        int numberToCompare = 4;
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
     * @return The sum of the dice that reads five
     */
    public static int fives(int... dice) {
        int sum = 0;
        int numberToCompare = 5;
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
     * @return The sum of the dice that reads six
     */
    public static int sixes(int... dice) {
        int sum = 0;
        int numberToCompare = 6;
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
     * @return The sum of all dices
     */
    public static int chance(int... dice) {
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
     */
    private static int[] generateFrequencyArray(int... dice) {
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
     */
    public static int yatzyGame(int... dice) {
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
     */
    public static int highestPair(int... dice) {
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
     */
    public static int highestTwoPairs(int... dice) {
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
     */
    public static int threeOfAKind(int... dice) {
        int[] frequencyArray = generateFrequencyArray(dice);

        return nOfAKind(frequencyArray, 3);
    }

    /**
     * 
     * @param dice
     * @return if at least one number is present four times then the quadruple of
     *         the number, otherwise 0
     */
    public static int fourOfAKind(int... dice) {
        int[] frequencyArray = generateFrequencyArray(dice);

        return nOfAKind(frequencyArray, 4);
    }

    /**
     * 
     * @param dice
     * @return If all numbers between one and five are present (and only once) (no
     *         matter the order) then 15, otherwise 0
     */
    public static int smallStraight(int... dice) {
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
     */
    public static int largeStraight(int... dice) {
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
     */
    public static int fullHouse(int... dice) {
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
