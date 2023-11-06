package dto;

import models.Expense;

import java.util.List;

public class UserSettleUpResponseDTO {
    public UserSettleUpResponseDTO(List<Expense> expenses) {
        this.expenses = expenses;
    }

    List<Expense> expenses; // create a ExpenseDTO
}
