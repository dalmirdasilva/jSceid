
package dao.hibernate;

import dao.DAOFactory;
import dao.GenericDAO;
import org.hibernate.SessionFactory;

public class HibernateDAOFactory extends DAOFactory {
 
    private SessionFactory sessionFactory;
    
    @Override
    public GenericDAO getNewDAO(Class daoClass) {
        return instantiateDAO(daoClass);
    }
    
    private GenericHibernateDAO instantiateDAO(Class daoClass) {
        try {
            GenericHibernateDAO dao = (GenericHibernateDAO)daoClass.newInstance();
            dao.setSessionFactory(getSessionFactory());
            return dao;
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
        }
    }
    
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            throw new IllegalStateException("Session has not been set on DAO before usage");
        }
        return sessionFactory;
    }
}
