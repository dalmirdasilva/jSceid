package dao.hibernate;

import dao.PatientDAO;
import entity.Patient;

public class PatientHibernateDAO
        extends GenericHibernateDAO<Patient, Long>
        implements PatientDAO {
}