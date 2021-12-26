package usantateclaProxy.usantateclaProxy.utils.models;

public abstract class Command {

    protected String title;

    protected Command(String title) {
        this.title = title;
    }

    public abstract void execute();

    public abstract boolean isActive();

    public String getTitle() {
        return this.title;
    }
}
