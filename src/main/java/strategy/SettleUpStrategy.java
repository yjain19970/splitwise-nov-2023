package strategy;

import models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SettleUpStrategy {

    public List<Expense> settlUp(List<Expense> expenses);
}
