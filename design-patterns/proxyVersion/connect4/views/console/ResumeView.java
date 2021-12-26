package proxyVersion.connect4.views.console;


import proxyVersion.connect4.controllers.ResumeController;
import proxyVersion.connect4.views.Message;
import proxyVersion.utils.views.YesNoDialog;

class ResumeView {

    void interact(ResumeController resumeController) {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        resumeController.resume(isResumed.isAffirmative());
    }

}
