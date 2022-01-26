public class GamePlay {

    private String playerName;

    private int[] dice;

    private int playerScore;

    private boolean[] hasCategoryBeenPlayedArray;

    public GamePlay(String playerName) {
        this.playerName = playerName;
        this.dice = new int[5];

        this.hasCategoryBeenPlayedArray = new boolean[CategoryEnum.values().length];
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void rollAllDice() {
        for (int index = 0; index < dice.length; index++) {
            dice[index] = DieRoller.roll();
        }
    }

    public void placeBetOnGivenCategory(CategoryEnum categoryEnum) throws YatzyException, GameException {
        if (this.hasCategoryBeenPlayedArray[categoryEnum.ordinal()]) {
            System.err.println("Already placed bet in this category");
            throw new GameException("Already placed bet in this category");
        }
        switch (categoryEnum) {
            case ONES:
                playerScore += Yatzy.ones(dice);
                break;
            case TWOS:
                playerScore += Yatzy.twos(dice);
                break;
            case THREES:
                playerScore += Yatzy.threes(dice);
                break;
            case FOURS:
                playerScore += Yatzy.fours(dice);
                break;
            case FIVES:
                playerScore += Yatzy.fives(dice);
                break;
            case SIXES:
                playerScore += Yatzy.sixes(dice);
                break;
            case CHANCE:
                playerScore += Yatzy.chance(dice);
                break;
            case FOUR_OF_A_KIND:
                playerScore += Yatzy.fourOfAKind(dice);
                break;
            case FULL_HOUSE:
                playerScore += Yatzy.fullHouse(dice);
                break;
            case HIGHEST_PAIR:
                playerScore += Yatzy.highestPair(dice);
                break;
            case HIGHEST_TWO_PAIRS:
                playerScore += Yatzy.highestTwoPairs(dice);
                break;
            case LARGE_STRAIGHT:
                playerScore += Yatzy.largeStraight(dice);
                break;
            case SMALL_STRAIGHT:
                playerScore += Yatzy.smallStraight(dice);
                break;
            case THREE_OF_A_KIND:
                playerScore += Yatzy.threeOfAKind(dice);
                break;
            case YATZY_GAME:
                playerScore += Yatzy.yatzyGame(dice);
                break;
            default:
                System.err.println("Category unknown");
                throw new GameException("Category unknown");
        }
        this.hasCategoryBeenPlayedArray[categoryEnum.ordinal()] = true;
    }

    public void displayScore() {
        System.out.println(playerName + " has " + playerScore + " points.");
    }
}
