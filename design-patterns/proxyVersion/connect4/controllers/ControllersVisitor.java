package proxyVersion.connect4.controllers;

public interface ControllersVisitor {

    void visit(StartController startController);

    void visit(PlayController playController);

    //TODO
    void visit(ResumeController resumeController);
}