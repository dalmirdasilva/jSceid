
package dao.hibernate;

import dao.InstitutionDAO;
import entity.Institution;

public class InstitutionHibernateDAO
        extends GenericHibernateDAO<Institution, Long>
        implements InstitutionDAO {
}