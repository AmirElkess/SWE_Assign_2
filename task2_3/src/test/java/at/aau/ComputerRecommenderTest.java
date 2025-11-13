package at.aau;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComputerRecommenderTest {

    /* Equivalence Partitions
     * -INF-0    ;InvalidBudgetException
     * 1-450     ;ENTRYLVL
     * 451-600   ;BDGTPC
     * 601-1500  ;GAMINGPC
     * 1501-INF  ;ENTHUSIASTPC
     */

    private final ComputerRecommender recommender = new ComputerRecommender();

    @Test
    void invalidBudgetTest() {
        assertThrows(InvalidBudgetException.class, () -> recommender.getRecommendedComputerTypePerBudget(0));
        assertThrows(InvalidBudgetException.class, () -> recommender.getRecommendedComputerTypePerBudget(-1));
    }

    @Test
    void entryLevelPartitionTest() throws InvalidBudgetException {
        assertEquals(ComputerType.ENTRYLVL, recommender.getRecommendedComputerTypePerBudget(1));
        assertEquals(ComputerType.ENTRYLVL, recommender.getRecommendedComputerTypePerBudget(450));
    }

    @Test
    void budgetPartitionTest() throws InvalidBudgetException {
        assertEquals(ComputerType.BDGTPC, recommender.getRecommendedComputerTypePerBudget(451));
        assertEquals(ComputerType.BDGTPC, recommender.getRecommendedComputerTypePerBudget(600));
    }

    @Test
    void gamingPartitionTest() throws InvalidBudgetException {
        assertEquals(ComputerType.GAMINGPC, recommender.getRecommendedComputerTypePerBudget(601));
        assertEquals(ComputerType.GAMINGPC, recommender.getRecommendedComputerTypePerBudget(1500));
    }

    @Test
    void enthusiastPartitionTest() throws InvalidBudgetException {
        assertEquals(ComputerType.ENTHUSIASTPC, recommender.getRecommendedComputerTypePerBudget(1501));
        assertEquals(ComputerType.ENTHUSIASTPC, recommender.getRecommendedComputerTypePerBudget(99999));
    }
}

