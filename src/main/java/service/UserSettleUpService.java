package service;

import models.Expense;
import models.ExpenseUser;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.ExpenseUserRepository;
import repo.UserRepository;
import strategy.SettleUpStrategy;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserSettleUpService implements IUserSettleUpService {


    private ExpenseUserRepository expenseUserRepository;
    private UserRepository userRepository;
    private SettleUpStrategy settleUpStrategy;

    @Autowired
    public UserSettleUpService(ExpenseUserRepository expenseUserRepository,
                               UserRepository userRepository,
                               SettleUpStrategy settleUpStrategy) {
        this.expenseUserRepository = expenseUserRepository;
        this.userRepository = userRepository;
        this.settleUpStrategy = settleUpStrategy;
    }




    /**
     * This will settle up an individual user.
     * @param userId
     * @return
     */
    @Override
    public List<Expense> settleUpUser(Long userId) throws Exception {
        /**
         * S1. Get all the expenses for that particular user.
         * S2. Iterate and find who paid extra and less
         * S3. Take the heap approach
         * S4. Just return transaction objects where userId is involed.
         */

        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new Exception();
        }
        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user.get());


        Set<Expense> expenseSet = new HashSet<>();
        for(ExpenseUser eu : expenseUsers){
            expenseSet.add(eu.getExpense());
        }

        List<Expense> transactions = settleUpStrategy.
                settlUp(expenseSet.stream().collect(Collectors.toList()));


        List<Expense> expensesToReturn = new ArrayList<>();

        for(Expense e : transactions){
            for(ExpenseUser u : e.getExpenseUsers()){
                if(u.equals(userId)){
                    expensesToReturn.add(e);
                }
            }
        }
        return expensesToReturn;
    }

    /**
     *  this will settle up users in that particular group.
     * @param groupId
     * @return
     */
    @Override
    public List<Expense> settleUpGroup(Long groupId) {
        /**
         * S1. Get all the expenses for that particular group.
         * S2. Iterate and find who paid extra and less
         * S3. Take the heap approach
         * S4. Return all transaction objects
         */

        return null;
    }
}
