package concretemanor.tools.teamview.actions;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

@UrlBinding("/list.action")
public class ObsoleteUrlActionBean extends ActionBeanBase implements ActionBean {
	@DefaultHandler
	public Resolution view() {
		return new RedirectResolution("/a/List");
	}
}
