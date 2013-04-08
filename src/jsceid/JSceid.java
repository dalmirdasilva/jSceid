package jsceid;

import dao.AddressDAO;
import dao.AvatarDAO;
import dao.ClinicalExamDAO;
import dao.DAOFactory;
import dao.DiagnosticExamDAO;
import dao.InstitutionDAO;
import dao.MedicDAO;
import dao.PatientDAO;
import dao.PostOperatoryAvaliationDAO;
import dao.PostOperatoryEndoscopyDAO;
import dao.hibernate.AddressHibernateDAO;
import dao.hibernate.AvatarHibernateDAO;
import dao.hibernate.ClinicalExamHibernateDAO;
import dao.hibernate.DiagnosticExamHibernateDAO;
import dao.hibernate.HibernateDAOFactory;
import dao.hibernate.InstitutionHibernateDAO;
import dao.hibernate.MedicHibernateDAO;
import dao.hibernate.PatientHibernateDAO;
import dao.hibernate.PostOperatoryAvaliationHibernateDAO;
import dao.hibernate.PostOperatoryEndoscopyHibernateDAO;
import entity.Avatar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class JSceid {

    private static SessionFactory sessionFactory;
    private static Session session;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        try {
            Configuration c = new Configuration();
            c.configure();
            sessionFactory = c.buildSessionFactory();
            session = sessionFactory.openSession();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        DAOFactory daoFactory = new HibernateDAOFactory();
        daoFactory.setSession(session);

        PatientDAO patientDAO = (PatientDAO) daoFactory.getNewDAO(PatientHibernateDAO.class);
        MedicDAO medicDAO = (MedicDAO) daoFactory.getNewDAO(MedicHibernateDAO.class);
        AddressDAO addressDAO = (AddressDAO) daoFactory.getNewDAO(AddressHibernateDAO.class);
        InstitutionDAO institutionDAO = (InstitutionDAO) daoFactory.getNewDAO(InstitutionHibernateDAO.class);
        ClinicalExamDAO clinicalExamDAO = (ClinicalExamDAO) daoFactory.getNewDAO(ClinicalExamHibernateDAO.class);
        DiagnosticExamDAO diagnosticExamDAO = (DiagnosticExamDAO) daoFactory.getNewDAO(DiagnosticExamHibernateDAO.class);
        PostOperatoryAvaliationDAO postOperatoryAvaliationDAO = (PostOperatoryAvaliationDAO) daoFactory.getNewDAO(PostOperatoryAvaliationHibernateDAO.class);
        PostOperatoryEndoscopyDAO postOperatoryEndoscopyDAO = (PostOperatoryEndoscopyDAO) daoFactory.getNewDAO(PostOperatoryEndoscopyHibernateDAO.class);
        AvatarDAO avatarDAO = (AvatarDAO) daoFactory.getNewDAO(AvatarHibernateDAO.class);

        
        Avatar a = avatarDAO.findById((long) 2, true);
        
        ImageViewer frame = new ImageViewer();
        frame.abc(a.getImage());
        frame.show();

        
        /*

        File f = new File("/home/dalmir/Desktop/evolution.jpg");
        FileInputStream fis = new FileInputStream(f);


        byte[] image = new byte[(int) f.length()];
        fis.read(image);
        avatarDAO.saveEntity(new Avatar(image));
        
        
        /*
         postOperatoryAvaliationDAO.saveEntity(new PostOperatoryAvaliation(new Patient(new Medic(new Institution(new Address()), new Address()), "Paulo", new Address())));
        
        
         /*
         Institution i = institutionDAO.findById((long) 1, true);
         for (Medic m : i.getMedics()) {
         m.setAddress(new Address());
         }
         institutionDAO.saveEntity(i);
        
        
         //institutionDAO.deleteEntity(i);
         /*
         Patient p = new Patient("OPA", i.getAddress());
         if (p.getPostOperatoryEndoscopies() == null) {
         p.setPostOperatoryEndoscopies(new HashSet<PostOperatoryEndoscopy>());
         }
         p.getPostOperatoryEndoscopies().add(new PostOperatoryEndoscopy(new Date()));
         System.out.println(((Medic) i.getMedics().toArray()[0]).getPatients().add(p));
         //        System.out.println(patientDAO.findById((long) 3, true));
        
         institutionDAO.saveEntity(i);
         System.out.println(i);
        
         //Institution i = new Institution(new Address(), "UFSM", "www.ufsm.br", "5599887744");
         //institutionDAO.saveEntity(i);
        
         /*
         Medic m = (Medic) medicDAO.findById((long) 2, false);
         Patient p = (Patient) patientDAO.findById((long) 2, false);
         DiagnosticExam de = new DiagnosticExam(p);
         //diagnosticExamDAO.saveEntity(de);
         System.out.println(diagnosticExamDAO.findAll());
         /*
         Medic e = new Medic();
         e.setName("Paulo");
         String[] s = {"id",
         "institution",
         "patients",
         "address",
         "phone",
         "email",
         "updatedAt",
         "createdAt",
         "active"};
         Medic m = (Medic) medicDAO.findById((long) 2, false);
         //Patient p = new Patient("Jose");
         //p.setAddress(new Address());
         //m.getPatients().add(p);
         //medicDAO.saveEntity(m);
         //m.getAddress();
         //System.out.println(m.getName());
         medicDAO.saveEntity(m);
        
        

         /*
         for (Institution i : institutionDAO.findAll()) {
         //institutionDAO.deleteEntity(i);
         }
        
         //institutionDAO.saveEntity(new Institution(new Address(), "UFS", "", ""));
         Institution i = institutionDAO.findById((long) 3, true);
         i.getMedics().add(new Medic(null, new Address(), "Paulo", "", "", true));
         institutionDAO.saveEntity(i);
        
        
        
        
        
         //        medicDAO.saveEntity(new Medic(null, new Address(), "Paulo", "", "", true));
        
        
        
         /*
         Institution i;
        
         i = institutionDAO.findById((long) 1, true);
         i.setName("UFSM");
         i.getAddress().setUf("RS");
         //institutionDAO.saveEntity(i);
         System.out.println(i);
                
         Medic m = new Medic();
         m.setAddress(new Address());
         m.setName("pailin");
         i.getMedics().add(m);
         m.setInstitution(i);
        
         institutionDAO.saveEntity(i);
        
         /*
         Patient p = new Patient();
         p.setGender(Gender.FEMALE);
         p.setAddress(new Address());
         p.setMedic(m);
         patientDAO.saveEntity(p);
        
         System.out.println(p);
        
        
        


         //Medic m = medicDAO.findAll().get(0);
         //m.getPatients().add(new Patient("Jose ferrari"));
         //medicDAO.saveEntity(m);

         //Patient p = (Patient) m.getPatients().toArray()[0];
         //m.getPatients().remove(p);
         //medicDAO.saveEntity(m);


         //Set<Patient> ps = m.getPatients();
         //Patient p = (Patient) ps.toArray()[0];
         //ps.remove(p);

         //patientDAO.deleteEntity(p);

         //System.out.println(m.getId());
         //System.out.println(m);
         //ps.clear();



         //        m.setPatients(new HashSet<Patient>());
         //        m.getPatients().add((Patient) ps.toArray()[0]);
         //        medicDAO.saveEntity(m);

         //        Patient p = (Patient) m.getPatients().toArray()[0];
         //      p.getClinicalExams().add(new ClinicalExam());

         //        ClinicalExam c = new ClinicalExam();
         //        c.setPatient(p);
         //        clinicalExamDAO.saveEntity(c);

         //        System.out.println(p.getClinicalExams());

         //patientDAO.saveEntity(p);

         //medicDAO.saveEntity(m);



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
