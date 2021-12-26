package passiveViewVersion.connect4.views.console;

import passiveViewVersion.connect4.views.MenuView;
import passiveViewVersion.utils.views.BoundedIntDialog;
import passiveViewVersion.utils.views.Console;

public class ConcreteMenuView implements MenuView {

    @Override
    public void showMenuOption (String option) {
        Console.getInstance().write(option);
    }

    public int promptUserInput(int optionNumber, String promptMessage) {
        return new BoundedIntDialog(1, optionNumber).read(promptMessage);
    }
}