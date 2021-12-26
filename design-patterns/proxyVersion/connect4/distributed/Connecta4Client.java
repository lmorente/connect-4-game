package proxyVersion.connect4.distributed;

import proxyVersion.connect4.Connect4;
import proxyVersion.connect4.controllers.Logic;
import proxyVersion.connect4.views.View;
import proxyVersion.connect4.views.console.ConsoleView;

public class Connecta4Client extends Connect4 {

	private LogicProxy logicProxy;
	
	@Override
	protected Logic createLogic() {
		this.logicProxy = new LogicProxy();
		return this.logicProxy;
	}

	@Override
	protected View createView() {
		return new ConsoleView();
	}

	@Override
	protected void play() {
		super.play();
		this.logicProxy.close();
	}
	
	public static void main(String[] args) {
		new Connecta4Client().play();
	}

}
