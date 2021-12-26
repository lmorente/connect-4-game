package proxyVersion.connect4.controllers.implementation;


import proxyVersion.connect4.models.session.SessionImplementation;
import proxyVersion.connect4.controllers.Logic;
import proxyVersion.connect4.models.StateValue;

public class LogicImplementation extends Logic {

	protected StartControllerImplementation startControllerImplementation;

	protected PlayControllerImplementation playControllerImplementation;

	protected ResumeControllerImplementation resumeControllerImplementation;

	public LogicImplementation() {
		this.session = new SessionImplementation();
		this.acceptorControllers.put(StateValue.INITIAL, new StartControllerImplementation(this.session));
		this.acceptorControllers.put(StateValue.IN_GAME, new PlayControllerImplementation(this.session));
		this.acceptorControllers.put(StateValue.RESUME, new ResumeControllerImplementation(this.session));
		this.acceptorControllers.put(StateValue.EXIT, null);
	}

}
