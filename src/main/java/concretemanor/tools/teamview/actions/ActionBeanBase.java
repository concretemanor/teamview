package concretemanor.tools.teamview.actions;

import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.integration.spring.SpringBean;
import concretemanor.tools.teamview.service.IService;

public class ActionBeanBase {
    ActionBeanContext context;
        
    @SpringBean
    private IService service;

    public ActionBeanBase() {
        super();
    }

    protected IService getService() {
        return service;
    }
        
    public void setContext(ActionBeanContext context) {
        this.context = context;
    }

    public ActionBeanContext getContext() {
        return context;
    }


}