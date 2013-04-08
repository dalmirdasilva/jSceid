package dao.hibernate;

import dao.ClinicalExamDAO;
import entity.ClinicalExam;

public class ClinicalExamHibernateDAO
        extends GenericHibernateDAO<ClinicalExam, Long>
        implements ClinicalExamDAO {
}