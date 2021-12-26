package connect4.models;

public class RegistryBuilder {

    private Game game;
    private Registry register;

    public RegistryBuilder(){
        this.game = new Game();
        this.game.reset();
        this.register = new Registry(this.game);
    }

    public void makeUndo(int times) {
        for (int i=0; i<times; i++){
            assert this.register.isUndoable();
            this.register.undo();
        }
    }

    public boolean isUndoable(){
        return this.register.isUndoable();
    }

    public boolean isRedoable(){
        return this.register.isRedoable();
    }

    public void makeUndo() {
        this.makeUndo(1);
    }

    public void putToken(int column){
        this.game.putToken(column);
        this.register.register();
    }

    public void makeRedo(int times) {
        for (int i=0; i<times; i++){
            assert this.register.isRedoable();
            this.register.redo();
        }
    }

    public void makeRedo() {
        this.makeRedo(1);
    }

    public void reset() {
        this.game.reset();
    }
}
