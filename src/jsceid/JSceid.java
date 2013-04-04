package jsceid;

import dao.AddressDAO;
import dao.ClinicalDAO;
import dao.DAOFactory;
import dao.InstitutionDAO;
import dao.MedicDAO;
import dao.PatientDAO;
import dao.hibernate.AddressHibernateDAO;
import dao.hibernate.ClinicalHibernateDAO;
import dao.hibernate.HibernateDAOFactory;
import dao.hibernate.InstitutionHibernateDAO;
import dao.hibernate.MedicHibernateDAO;
import dao.hibernate.PatientHibernateDAO;
import entity.Medic;
import entity.Patient;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JSceid {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        try {
            Configuration c = new Configuration();
            c.configure();
            sessionFactory = c.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        DAOFactory daoFactory = new HibernateDAOFactory();
        daoFactory.setSessionFactory(sessionFactory);

        PatientDAO patientDAO = (PatientDAO) daoFactory.getNewDAO(PatientHibernateDAO.class);
        MedicDAO medicDAO = (MedicDAO) daoFactory.getNewDAO(MedicHibernateDAO.class);
        ClinicalDAO clinicalDAO = (ClinicalDAO) daoFactory.getNewDAO(ClinicalHibernateDAO.class);
        AddressDAO addressDAO = (AddressDAO) daoFactory.getNewDAO(AddressHibernateDAO.class);
        InstitutionDAO institutionDAO = (InstitutionDAO) daoFactory.getNewDAO(InstitutionHibernateDAO.class);

        Medic m = medicDAO.findAll().get(0);
        Patient p = new Patient(m, "Paulo2", 111, 100, true, "white", "agricultor", "asdasd", "", "", "", true);
        //patientDAO.saveEntity(p);
        //m.getPatients().add(p);
        System.out.println(m.getPatients());
        medicDAO.saveEntity(m);
        
        
        
        //addressDAO.saveEntity(new Address("Brasil", "RS", "POA", "Dos Andradas", 1000));
        //addressDAO.saveEntity(new Address("Brasil", "RS", "POA", "Almirantes", 123));
        //addressDAO.saveEntity(new Address("Brasil", "RS", "POA", "Andradas", 1002));
        //addressDAO.saveEntity(new Address("Brasil", "RS", "POA", "Henrique", 12005));

        //Address address = addressDAO.findById((long) 1, false);
        //institutionDAO.saveEntity(new Institution(address, "UFSM", "ufsm@ufsm.com", "55999888"));
        
        //for (Institution i : institutionDAO.findAll()) {
        //    System.out.println(i.getName());
        //}

        //Institution i = institutionDAO.findAll().get(0);
        
        //i.setAddress(new Address("US", "RS", "asd", "asdads", 1000));
        
        //institutionDAO.saveEntity(i);

        /*
         patientDAO.saveEntity(new Patient(0, "Pedroso", 122, 56, true, "Amarelo", "Estudante", "Rua da quadra", "LS", "LS", "5588774455", true));
         medicDAO.saveEntity(new Medic(0, "Pedro", "5599254645", "pedro@gmail.com", "POA", true));
         List<Patient> find = patientDAO.findByExample(new Patient(0, "Pedroso", 122, 56, true, "Amarelo", "Estudante", "Rua da quadra", "LS", "LS", "5588774455", true), null);
         for (Patient p : find) {
         System.out.println(p.getAddress());
         }
         */
        //List<Medic> ms = medicDAO.findByExample(new Medic(0, "Pedro", "5599254645", "pedro@gmail.com", "POA", true), null);

        //Patient p = new Patient(ms.get(0), "Pedrosinho", 122, 56, true, "Amarelo", "Estudante", "Rua da quadra", "LS", "LS", "5588774455", true);
        //patientDAO.saveEntity(p);

        //for (Patient p1 : patientDAO.findAll()) {    
        //    System.out.println(p1.getMedic().getCity());
        //}

        //for (Patient p : ms.get(0).getPatients()) {
        //    System.out.println(p.getName());
        //}
    }
}
