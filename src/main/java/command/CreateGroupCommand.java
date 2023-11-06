package command;

import org.springframework.stereotype.Component;

@Component
public class CreateGroupCommand implements Command{
    @Override
    public void execute(String input) {

    }

    @Override
    public boolean matches(String input) {
        return false;
    }
}
