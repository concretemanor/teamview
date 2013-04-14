package concretemanor.tools.teamview.actions.admin;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.util.Log;

import com.google.gson.Gson;

import concretemanor.tools.teamview.actions.PersonActionTeamBase;
import concretemanor.tools.teamview.domain.Person;
import concretemanor.tools.teamview.domain.Team;

@UrlBinding("/a/admin/LoadNonMembers")
public class LoadNonMembersActionBean extends PersonActionTeamBase implements ActionBean {
	private static Log log = Log.getInstance(LoadNonMembersActionBean.class);

	private Team team;
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}

	private String prefix;
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	private int maxRows;
	public int getMaxRows() {
		return maxRows;
	}
	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}

	@DefaultHandler
	public Resolution loadData() {
		log.debug("enter loadData");

		List<HashMap<String,Object>> data = new ArrayList<HashMap<String,Object>>();
		if (prefix != null && prefix.length() > 0) {
			List<Person> people = getService().getByNotTeam(getService().getTeamById(team.getId()),prefix,maxRows);
			log.debug("getByNotTeam found "+people.size()+"/"+people);
			for (final Person person : (List<Person>)people) {
				HashMap<String,Object> datum = new HashMap<String,Object>();
				datum.put("label",person.getName());
				datum.put("value",person.getId());
				data.add(datum);
			}
		}
		
		log.debug("loadData found "+data.size()+"/"+data);

		Gson gson = new Gson();
		gson = new Gson();

		String json = gson.toJson(data);

		return new StreamingResolution("text",new StringReader(json));
	}

}
