package concretemanor.tools.teamview.hibernate;

import concretemanor.tools.teamview.domain.Status;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * User: shin4590
 * Date: 12/17/12
 */
public class StatusUserType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.INTEGER};
    }

    @Override
    public Class returnedClass() {
        return Status.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        if (o instanceof Status && o1 instanceof Status) {
            Status current = (Status) o;
            Status other = (Status) o1;
            return current.name().equals(other.name());
        }
        return false;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException {
        Integer value = resultSet.getInt(strings[0]);
        return resultSet.wasNull() ? null : Status.enumFor(value);
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException {
        if (o == null) {
            throw new HibernateException(Status.class + " cannot have a null value");
        }
        Status status = (Status) o;
        preparedStatement.setInt(i, status.id());
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return o;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return null;
    }
}
