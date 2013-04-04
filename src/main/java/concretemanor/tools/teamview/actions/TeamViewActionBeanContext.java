package concretemanor.tools.teamview.actions;

import java.util.Date;

import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.util.Log;

public class TeamViewActionBeanContext extends ActionBeanContext {
    private static Log log = Log.getInstance(TeamViewActionBeanContext.class);

    private Date date;
    public Date getDate() {
	log.debug("getDate:" + date);
	return date;
    }
    public void setDate(Date date) {
	log.debug("setDate:" + date);
	this.date = date;
    }
}
