
package dao.hibernate;

import dao.ClinicalDAO;
import entity.Clinical;

public class ClinicalHibernateDAO
        extends GenericHibernateDAO<Clinical, Long>
        implements ClinicalDAO {
}