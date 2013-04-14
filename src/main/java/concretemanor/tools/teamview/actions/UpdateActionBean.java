package concretemanor.tools.teamview.actions;

import java.util.Date;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.util.Log;
import concretemanor.tools.teamview.domain.Status;
import concretemanor.tools.teamview.service.IService;

@UrlBinding("/a/Update")
public class UpdateActionBean extends PersonActionTeamBase implements ActionBean {
	private static Log loggie = Log.getInstance(UpdateActionBean.class);

	@SpringBean
	private IService service;
	
	protected IService getService() {
		return service;
	}
	
	private Status cellValue;
	public void setCellValue(Status cellValue) {
		this.cellValue = cellValue;
	}

	private Integer personId;
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	
	public Integer dayIndex;
	public void setDayIndex(Integer dayIndex) {
		this.dayIndex = dayIndex;
	}

	@DefaultHandler
	public Resolution changeStatus() {
		Date date = dateFrom(dayIndex);
		loggie.debug("update "+personId+" "+dayIndex+" "+date+" "+cellValue);
		service.updateStatus(personId,date,cellValue);

		return null;
	}
}
