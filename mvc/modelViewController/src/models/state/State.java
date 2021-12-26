package models.state;

public class State {

    private StateGame stateGame;

    public State() {
        this.stateGame = StateGame.START;
    }

    public StateGame getStateGame() {
        return stateGame;
    }

    public void nextState() {
        this.stateGame = StateGame.values()[this.stateGame.ordinal() + 1];
    }

    public void reset() {
        this.stateGame = StateGame.START;
    }

    public void exit() {
        this.stateGame = StateGame.EXIT;
    }
}
