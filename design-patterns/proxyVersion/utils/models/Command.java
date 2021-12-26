package proxyVersion.utils.models;

public abstract class Command extends WithConsoleView {

	protected String title;
	
	protected Command(String title) {
		this.title = title;
	}

	protected abstract void execute();

	public abstract boolean isActive();

	public String getTitle() {
		return this.title;
	}

}
