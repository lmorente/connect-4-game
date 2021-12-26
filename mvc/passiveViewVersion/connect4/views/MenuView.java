package passiveViewVersion.connect4.views;

public interface MenuView {
    
    void showMenuOption (String message);

    int promptUserInput(int optionNumber, String promptMessage);
}