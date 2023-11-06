package service;

import models.Expense;

import java.util.List;

public interface IUserSettleUpService {

    public List<Expense> settleUpUser(Long userId) throws Exception;
    public List<Expense> settleUpGroup(Long groupId);
}
