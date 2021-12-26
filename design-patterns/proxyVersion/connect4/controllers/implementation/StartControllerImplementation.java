package proxyVersion.connect4.controllers.implementation;


import proxyVersion.connect4.models.session.Session;
import proxyVersion.connect4.models.session.SessionImplementation;
import proxyVersion.connect4.controllers.StartController;

public class StartControllerImplementation extends StartController {

	SessionImplementation sessionImplementation;

	public StartControllerImplementation(Session session) {
		super(session);
		this.sessionImplementation = ((SessionImplementation) this.session);
	}

	public void createPlayers(int numberOfUsers) {
		this.sessionImplementation.createPlayers(numberOfUsers);
	}

	@Override
	public void start() {
		this.sessionImplementation.next();		
	}
}
