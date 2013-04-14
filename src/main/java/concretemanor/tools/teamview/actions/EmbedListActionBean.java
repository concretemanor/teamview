package concretemanor.tools.teamview.actions;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

@UrlBinding("/a/EmbedList")
public class EmbedListActionBean extends ListActionBean implements ActionBean {
    public Resolution refresh() {
        return new ForwardResolution("/embed.jsp");
    }
}