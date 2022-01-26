import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.Test.None;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class GamePlayTest {

    public void onesSuccessfulBet() throws YatzyException, GameException {
        GamePlay gamePlay = new GamePlay("Ashfack");

        try (MockedStatic<DieRoller> utilities = Mockito.mockStatic(DieRoller.class)) {
            utilities.when(DieRoller::roll).thenReturn(1);
            gamePlay.rollAllDice();
        }
        CategoryEnum categoryEnum = CategoryEnum.ONES;
        gamePlay.placeBetOnGivenCategory(categoryEnum);
        assertEquals(5, gamePlay.getPlayerScore());

    }

    public void onesFailureBet() throws YatzyException, GameException {
        GamePlay gamePlay = new GamePlay("Ashfack");

        try (MockedStatic<DieRoller> utilities = Mockito.mockStatic(DieRoller.class)) {
            utilities.when(DieRoller::roll).thenReturn(2);
            gamePlay.rollAllDice();
        }
        CategoryEnum categoryEnum = CategoryEnum.ONES;
        gamePlay.placeBetOnGivenCategory(categoryEnum);
        assertEquals(0, gamePlay.getPlayerScore());
    }

    @Test(expected = None.class)
    public void onesAlreadyPlacedBet() throws YatzyException, GameException {
        GamePlay gamePlay = new GamePlay("Ashfack");

        try (MockedStatic<DieRoller> utilities = Mockito.mockStatic(DieRoller.class)) {
            utilities.when(DieRoller::roll).thenReturn(1);
            gamePlay.rollAllDice();
        }
        CategoryEnum categoryEnum = CategoryEnum.ONES;
        gamePlay.placeBetOnGivenCategory(categoryEnum);
        assertEquals(5, gamePlay.getPlayerScore());

        gamePlay.rollAllDice();
        assertThrows(GameException.class, () -> {
            gamePlay.placeBetOnGivenCategory(categoryEnum);
        });

        assertEquals(5, gamePlay.getPlayerScore());
    }

    @Test(expected = None.class)
    public void twoDifferentCategoriesBet() throws YatzyException, GameException {
        GamePlay gamePlay = new GamePlay("Ashfack");

        try (MockedStatic<DieRoller> utilities = Mockito.mockStatic(DieRoller.class)) {
            utilities.when(DieRoller::roll).thenReturn(1);
            gamePlay.rollAllDice();
        }
        CategoryEnum categoryEnum = CategoryEnum.ONES;
        gamePlay.placeBetOnGivenCategory(categoryEnum);
        assertEquals(5, gamePlay.getPlayerScore());

        try (MockedStatic<DieRoller> utilities = Mockito.mockStatic(DieRoller.class)) {
            utilities.when(DieRoller::roll).thenReturn(2);
            gamePlay.rollAllDice();
        }

        categoryEnum = CategoryEnum.TWOS;

        gamePlay.placeBetOnGivenCategory(categoryEnum);

        assertEquals(15, gamePlay.getPlayerScore());
    }

}
