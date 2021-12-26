package proxyVersion.connect4.views;



import proxyVersion.connect4.controllers.AcceptorController;
import proxyVersion.connect4.controllers.ControllersVisitor;


public interface View extends ControllersVisitor {

	void interact(AcceptorController acceptorController);
}