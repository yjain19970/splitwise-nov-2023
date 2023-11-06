package command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands = new ArrayList<>();

    @Autowired
    public CommandExecutor(SettleUpUserCommand stlUpCommand) {
        commands.add(stlUpCommand);
    }

    public void addCommand(Command command){
        commands.add(command);
    }

    public void removeCommand(Command cmd){
        commands.remove(cmd);
    }


    public void executeCommand(String input){
        for(Command c: commands){
            if(c.matches(input)){
                c.execute(input);
                break;
            }
        }
    }
}
