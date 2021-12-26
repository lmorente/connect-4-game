package proxyVersion.connect4.views.console;

import proxyVersion.connect4.controllers.PlayController;
import proxyVersion.connect4.views.console.menu.PlayMenu;

public class PlayView {

    public void interact(PlayController playController) {
        new PlayMenu(playController).execute();
    }

}
