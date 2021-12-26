package usantateclaProxy.usantateclaProxy.connect4.views.console.menu;


import usantateclaProxy.usantateclaProxy.utils.models.ClosedInterval;
import usantateclaProxy.usantateclaProxy.utils.views.Console;

import java.util.ArrayList;

public class Menu {

    private static final String TITLE_OPTION = "----- Choose one option -----";

    private ArrayList<Command> commands;

    public Menu() {
        this.commands = new ArrayList<Command>();
    }

    public void execute() {
        ArrayList<Command> commands = new ArrayList<Command>();
        for (int i = 0; i < this.commands.size(); i++) {
            if (this.commands.get(i).isActive()) {
                commands.add(this.commands.get(i));
            }
        }
        assert commands.size() > 0;

        boolean error;
        int option;
        do {
            error = false;
            Console.getInstance().writeln();
            Console.getInstance().writeln(Menu.TITLE_OPTION);
            for (int i = 0; i < commands.size(); i++) {
                Console.getInstance().writeln((i + 1) + ") " + commands.get(i).getTitle());
            }
            option = Console.getInstance().readInt("") - 1;
            if (!new ClosedInterval(0, commands.size() - 1).isIncluded(option)) {
                error = true;
            }
        } while (error);
        commands.get(option).execute();
    }

    protected void addCommand(Command command) {
        this.commands.add(command);
    }
}
