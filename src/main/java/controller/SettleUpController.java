package controller;

import dto.UserSettleUpRequestDTO;
import dto.UserSettleUpResponseDTO;
import models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.IUserSettleUpService;

import java.util.List;

@Controller
public class SettleUpController {

    private IUserSettleUpService userSettleUpService;


    @Autowired
    public SettleUpController(IUserSettleUpService userSettleUpService) {
        this.userSettleUpService = userSettleUpService;
    }

    public UserSettleUpResponseDTO settleUpUser(UserSettleUpRequestDTO dto){
        List<Expense> expenses = userSettleUpService.settleUpUser(dto.getUserId());
        return new UserSettleUpResponseDTO(expenses);

        /**
         * ToDo: add try-catch statements by self.
         */
    }
}
