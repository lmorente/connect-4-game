package passiveViewVersion.connect4.views.console;

import passiveViewVersion.connect4.views.Message;
import passiveViewVersion.connect4.views.ResumeView;
import passiveViewVersion.utils.views.YesNoDialog;

class ConcreteResumeView implements ResumeView {

    public boolean read() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        return isResumed.isAffirmative();
    }
}
