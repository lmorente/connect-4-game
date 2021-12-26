package passiveViewVersion.connect4;

import passiveViewVersion.connect4.views.ViewFactory;
import passiveViewVersion.connect4.views.console.ConsoleViewFactory;

class ConsoleConnect4 extends Connect4 {

	@Override
	protected ViewFactory createViewFactory(){
		return new ConsoleViewFactory();
	}

	public static void main(String[] args) {
		new ConsoleConnect4().play();
	}

}
