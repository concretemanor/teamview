package concretemanor.tools.teamview.actions;

import java.util.Date;

import net.sourceforge.stripes.action.ActionBeanContext;

public class TeamViewActionBeanContext extends ActionBeanContext {
    private Date date;
    public Date getDate() {
	return date;
    }
    public void setDate(Date date) {
	this.date = date;
    }
}
