package designpatterns.connect4.models.session;

import designpatterns.connect4.models.Turn;

public class MementoGame {

    private Turn turn;

    public MementoGame(Turn turn) {
      this.turn = turn;
    }

    public Turn getTurn() {
        return this.turn;
    }

}
