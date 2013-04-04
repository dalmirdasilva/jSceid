package dao.hibernate;

import dao.AddressDAO;
import entity.Address;

public class AddressHibernateDAO
        extends GenericHibernateDAO<Address, Long>
        implements AddressDAO {
}