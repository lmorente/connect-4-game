package connect4.views.console;

import connect4.views.Message;
import connect4.views.ResumeView;
import utils.views.YesNoDialog;

class ConcreteResumeView implements ResumeView {

    public boolean read() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        return isResumed.isAffirmative();
    }
}
