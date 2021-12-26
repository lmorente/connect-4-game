package connect4.controllers.menu;

import java.util.ArrayList;
import connect4.views.MenuView;

public class MenuController {
    
    private final ArrayList<Command> commandList;
    public static String OPTION = "Choose an option";

    public MenuController(){
        this.commandList = new ArrayList<>();
    }

    public void displayMenu(MenuView menuView){
        assert(this.commandList.size() > 0);

        for(int i=0; i<commandList.size(); i++){
            if(commandList.get(i).isActive()){
                int option = i + 1;
                menuView.showMenuOption(option + ")" + commandList.get(i).getName());
            }
        }
        int userDecision = menuView.promptUserInput(this.commandList.size(), MenuController.OPTION);
        this.commandList.get(userDecision - 1).execute();
    }

    public void addCommand(Command command){
        this.commandList.add(command);
    }
}
