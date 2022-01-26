import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Test.None;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class GamePlayTest {

    @Test(expected = None.class)
    public void onesSuccessfulBet() throws YatzyException {
        GamePlay gamePlay = new GamePlay("Ashfack");

        try (MockedStatic<DieRoller> utilities = Mockito.mockStatic(DieRoller.class)) {
            utilities.when(DieRoller::roll).thenReturn(1);
            gamePlay.rollAllDice();
        }
        CategoryEnum categoryEnum = CategoryEnum.ONES;
        gamePlay.placeBetOnGivenCategory(categoryEnum);
        assertEquals(5, gamePlay.getPlayerScore());

    }

    @Test(expected = None.class)
    public void onesFailureBet() throws YatzyException {
        GamePlay gamePlay = new GamePlay("Ashfack");

        try (MockedStatic<DieRoller> utilities = Mockito.mockStatic(DieRoller.class)) {
            utilities.when(DieRoller::roll).thenReturn(2);
            gamePlay.rollAllDice();
        }
        CategoryEnum categoryEnum = CategoryEnum.ONES;
        gamePlay.placeBetOnGivenCategory(categoryEnum);
        assertEquals(0, gamePlay.getPlayerScore());
    }

}
