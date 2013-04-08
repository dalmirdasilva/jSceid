package dao.hibernate;

import dao.AvatarDAO;
import entity.Avatar;

public class AvatarHibernateDAO
        extends GenericHibernateDAO<Avatar, Long>
        implements AvatarDAO {
}