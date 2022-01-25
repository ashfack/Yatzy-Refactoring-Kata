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
     * @param dice
     * @return if at least one number is present thrice then the triple of the number, otherwise 0
     */
    public static int threeOfAKind(int... dice) {
        int[] frequencyArray = generateFrequencyArray(dice);

        for (int index = MAXIMAL_NUMBER - 1; index >= MINIMAL_NUMBER - 1; index--) {
            if (3 <= frequencyArray[index]) {
                return (index + 1) * 3;
            }
        }
        return 0;
    }

    /**
     * 
     * @param dice
     * @return if at least one number is present four times then the quadruple of the number, otherwise 0
     */
    public static int fourOfAKind(int... dice) {
        int[] frequencyArray = generateFrequencyArray(dice);

        for (int index = MAXIMAL_NUMBER - 1; index >= MINIMAL_NUMBER - 1; index--) {
            if (4 <= frequencyArray[index]) {
                return (index + 1) * 4;
            }
        }
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}
