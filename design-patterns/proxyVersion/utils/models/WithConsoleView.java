package proxyVersion.utils.models;

import passiveViewVersion.utils.views.Console;

public abstract class WithConsoleView {

	protected Console console;

	protected WithConsoleView() {
		this.console = new Console();
	}

}
