package controllers;

import controllers.stages.EndController;
import controllers.stages.PlayController;
import controllers.stages.RestartController;
import controllers.stages.StartController;

public interface ControllersVisitor {

    void visit(StartController startController);

    void visit(PlayController playController);

    void visit(EndController endController);

    void visit(RestartController restartController);
}
