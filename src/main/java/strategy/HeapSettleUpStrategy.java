package strategy;

import models.Expense;

import java.util.List;

public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Expense> settlUp(List<Expense> expenses) {
        /**
         * This has 2 heaps.
         * 1. find who paid more and who paid less
         * 2. create heaps and find list<Transactions>
         *
         * Take max from both.
         *
         */
        return null;
    }
}
