package concretemanor.tools.teamview.dao;

import java.util.Date;
import java.util.List;

import concretemanor.tools.teamview.domain.PersonStatus;
import concretemanor.tools.teamview.domain.Team;

/**
 * User: shin4590
 * Date: 12/8/12
 */
public interface PersonStatusDao {

    /**
     * Gets a list of PersonStatus by range of dates
     * @param minDate
     * @param maxDate
     * @return
     */
    public List<PersonStatus> getByDateRange(Date minDate, Date maxDate);

    /**
     * Gets a list of PersonStatus for a specific Team, by range of dates
     * @param team
     * @param minDate
     * @param maxDate
     * @return
     */
    public List<PersonStatus> getByTeamAndDateRange(Team team, Date minDate, Date maxDate);

    /**
     * Saves the PersonStatus object
     * @param pstatus
     * @return
     */
    public PersonStatus save(PersonStatus pstatus);
}
