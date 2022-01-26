import java.util.concurrent.ThreadLocalRandom;

public class DieRoller {
    private static final int MINIMAL_NUMBER = 1;
    private static final int MAXIMAL_NUMBER = 6;
    public static int roll() {
        int randomNum = ThreadLocalRandom.current().nextInt(MINIMAL_NUMBER, MAXIMAL_NUMBER + 1);
        return randomNum;
    }
}
