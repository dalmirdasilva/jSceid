package dao.hibernate;

import dao.DiagnosticExamDAO;
import entity.DiagnosticExam;

public class DiagnosticExamHibernateDAO
        extends GenericHibernateDAO<DiagnosticExam, Long>
        implements DiagnosticExamDAO {
}