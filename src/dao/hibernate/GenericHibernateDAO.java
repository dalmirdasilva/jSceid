package dao.hibernate;

import dao.GenericDAO;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

public abstract class GenericHibernateDAO<T, K extends Serializable>
        implements GenericDAO<T, K> {

    private Class<T> persistentClass;
    private Session session = null;

    public GenericHibernateDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    public void setSession(Session session) {
        this.session = session;
    }

    protected Session getSession() {
        if (session == null) {
            throw new IllegalStateException("Session has not been set on DAO before usage");
        }
        return session;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T findById(K id, boolean lock) {
        T entity;
        if (lock) {
            entity = (T) session.load(getPersistentClass(), id, LockMode.UPGRADE);
        } else {
            entity = (T) session.load(getPersistentClass(), id);
        }
        session.flush();
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
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T saveEntity(T entity) {
        session.saveOrUpdate(entity);
        session.flush();
        return entity;
    }

    @Override
    public void deleteEntity(T entity) {
        session.delete(entity);
        session.flush();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByCriteria(Criterion... criterion) {
        Criteria criteria = session.createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            criteria.add(c);
        }
        List<T> list = criteria.list();
        session.flush();
        return list;
    }
}
