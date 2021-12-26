package proxyVersion.connect4;

import proxyVersion.connect4.controllers.Logic;
import proxyVersion.connect4.controllers.implementation.LogicImplementation;
import proxyVersion.connect4.views.console.ConsoleView;

class ConsoleConnect4Standalone extends Connect4 {

    @Override
    protected Logic createLogic() {
        return new LogicImplementation();
    }

    @Override
    protected ConsoleView createView(){
        return new ConsoleView();
    }

    public static void main(String[] args) {
        new ConsoleConnect4Standalone().play();
    }

}
