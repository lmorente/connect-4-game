package usantateclaProxy.usantateclaProxy.connect4.views.console;

import usantateclaProxy.usantateclaProxy.connect4.controllers.ResumeController;
import usantateclaProxy.usantateclaProxy.connect4.views.Message;
import usantateclaProxy.usantateclaProxy.utils.views.YesNoDialog;

class ResumeView {

    boolean interact(ResumeController resumeController) {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            resumeController.reset();
        } else {
            resumeController.nextState();
        }
        return isResumed.isAffirmative();
    }

}
