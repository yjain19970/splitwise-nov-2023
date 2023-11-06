package command;

import controller.SettleUpController;
import dto.UserSettleUpRequestDTO;
import dto.UserSettleUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpUserCommand implements Command{
    private SettleUpController controller;

    @Autowired
    public SettleUpUserCommand(SettleUpController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String input) {
        // u1 settle-up
        List<String> words = List.of(input.split("\\s+"));
        Long userId = Long.valueOf(words.get(0));
        UserSettleUpRequestDTO dto = new UserSettleUpRequestDTO(userId);
       UserSettleUpResponseDTO responseDTO= controller.settleUpUser(dto);

    }

    @Override
    public boolean matches(String input) {
        // u1 settle-up
        List<String> words = List.of(input.split("\\s+"));

        if(words.size() ==2 && words.get(1).equals("settle-up")){
            return true;
        }

        return false;
    }
}
