package dao.hibernate;

import dao.MedicDAO;
import entity.Medic;

public class MedicHibernateDAO
        extends GenericHibernateDAO<Medic, Long>
        implements MedicDAO {
}