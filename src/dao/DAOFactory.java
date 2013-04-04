/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.SessionFactory;

/**
 *
 * @author dalmir
 */
public abstract class DAOFactory {
    
    public abstract void setSessionFactory(SessionFactory sessionFactory);

    public abstract GenericDAO getNewDAO(Class daoClass);
}