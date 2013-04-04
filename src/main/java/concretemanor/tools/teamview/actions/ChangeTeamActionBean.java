package concretemanor.tools.teamview.actions;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.util.Log;


@UrlBinding("/changeteam.action")
public class ChangeTeamActionBean extends StatusContextActionBean implements ActionBean {
	private static Log loggie = Log.getInstance(ChangeTeamActionBean.class);
	
	@DefaultHandler
	public Resolution changeTeam() {
		loggie.debug("team changed to "+teamId);
		return new ForwardResolution("/main.jsp");
	}
}