package E04hospitalDatabase;

import E04hospitalDatabase.entities.Diagnose;
import E04hospitalDatabase.entities.Medicament;
import E04hospitalDatabase.entities.Patient;
import E04hospitalDatabase.entities.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_relate");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
//        Patient patient = new Patient("Jack", "Jones", "asdaasdasd", "jackjones@gmail.com", LocalDateTime.now(), "asdasdasd", true);
//        entityManager.persist(patient);
//        Diagnose diagnose = new Diagnose("Diabetes", "asdasdasd");
//        entityManager.persist(diagnose);
//        Medicament medicament = new Medicament("A medicament");
//        entityManager.persist(medicament);
//        Visitation visitation = new Visitation(LocalDateTime.now(), "asdasdasd", patient, diagnose);
//        entityManager.persist(visitation);
//
//        visitation.getMedicaments().add(medicament);
//        entityManager.persist(visitation);
        Patient patient = entityManager.find(Patient.class, 1);
        Set<Visitation> visitations = patient.getVisitations();

        entityManager.getTransaction().commit();
    }
}
