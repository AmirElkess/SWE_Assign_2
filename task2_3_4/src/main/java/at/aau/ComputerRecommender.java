package at.aau;

public class ComputerRecommender {
    /* Equivalence Partitions
     * -INF-0    ;InvalidBudgetException
     * 1-450     ;ENTRYLVL
     * 451-600   ;BDGTPC
     * 601-1500  ;GAMINGPC
     * 1501-INF  ;ENTHUSIASTPC
     */
    public ComputerType getRecommendedComputerTypePerBudget(int maxBudget) throws InvalidBudgetException {
        if (maxBudget <= 0) {
            throw new InvalidBudgetException("Budget must be a positive integer");
        }
        if (maxBudget <= 450) {
            return ComputerType.ENTRYLVL;
        }
        if (maxBudget <= 600) {
            return ComputerType.BDGTPC;
        }
        if (maxBudget <= 1500) {
            return ComputerType.GAMINGPC;
        }
        return ComputerType.ENTHUSIASTPC;
    }
}
