package connect4.views.console;

import connect4.views.MenuView;
import utils.views.BoundedIntDialog;
import utils.views.Console;

public class ConcreteMenuView implements MenuView {

    @Override
    public void showMenuOption (String option) {
        Console.getInstance().write(option);
    }

    public int promptUserInput(int optionNumber, String promptMessage) {
        return new BoundedIntDialog(1, optionNumber).read(promptMessage);
    }
}