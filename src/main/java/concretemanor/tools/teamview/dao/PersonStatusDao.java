package concretemanor.tools.teamview.dao;

import java.util.Date;
import java.util.List;

/**
 * User: shin4590
 * Date: 12/8/12
 */
public interface PersonStatusDao {

    public List<PersonStatusDao> getByDateRange(Date minDate, Date maxDate);
}
