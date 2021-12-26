package view;

import game.Game;
import view.console.Reader;
import view.console.Message;


public class ViewGame extends ModelView {

    ViewGame(Game game) {
        super(game);
    }

    public void StartGame() {
        Message.START_GAME.print();
        this.game.initGame();
    }

    public void play() {
        showPlayerOrder();
        this.game.playTurn(getPlayerOrder());
    }

    public boolean isInProgress() {
        return this.game.isInProgress();
    }

    public void endGame() {
        ViewBoard.printBoard(this.game);
        Message.END_GAME.print();
        Message.HEADER_SEPARATOR.print();
        Message.RESULT_GAME.print(game.getGoal().toString());

        if (game.isWinner()) {
            Message.RESULT_WINNER.print(game.getActivedPlayer());
        }
    }

    private Integer getPlayerOrder() {
        String input = Reader.read();

        while (!this.game.isValidTurn(Integer.parseInt(input))) {
            Message.INPUT_ERROR.print();
            input = Reader.read();
        }
        return Integer.parseInt(input);
    }

    private void showPlayerOrder() {
        Message.PLAYER_TURN.print(this.game.getActivedPlayer());
        ViewBoard.printBoard(this.game);
        Message.CHOOSE_COLUMN.print();
    }
}
