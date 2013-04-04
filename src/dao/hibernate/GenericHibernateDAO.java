package dao.hibernate;

import dao.GenericDAO;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

public abstract class GenericHibernateDAO<T, K extends Serializable>
        implements GenericDAO<T, K> {

    private Class<T> persistentClass;
    private SessionFactory sessionFactory;

    public GenericHibernateDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            throw new IllegalStateException("Session has not been set on DAO before usage");
        }
        return sessionFactory;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T findById(K id, boolean lock) {
        Session session = sessionFactory.openSession();
        T entity;
        if (lock) {
            entity = (T) session.load(getPersistentClass(), id, LockMode.UPGRADE);
        } else {
            entity = (T) session.load(getPersistentClass(), id);
        }
        session.flush();
        session.close();
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        return findByCriteria();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
        Session session = sessionFactory.openSession();
        Criteria criteriacrit = session.createCriteria(getPersistentClass());
        Example example = Example.create(exampleInstance);
        if (excludeProperty != null) {
            for (String exclude : excludeProperty) {
                example.excludeProperty(exclude);
            }
        }
        criteriacrit.add(example);
        List<T> list = criteriacrit.list();
        session.flush();
        session.close();
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T saveEntity(T entity) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(entity);
        session.flush();
        session.close();
        return entity;
    }

    @Override
    public void deleteEntity(T entity) {
        Session session = sessionFactory.openSession();
        session.delete(entity);
        session.flush();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByCriteria(Criterion... criterion) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            criteria.add(c);
        }
        List<T> list = criteria.list();
        session.flush();
        session.close();
        return list;
    }
}
