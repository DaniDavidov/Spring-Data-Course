package E01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gringotts");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        E01WizardDeposit wizardDeposit = new E01WizardDeposit("dani", "davidov", "asdasdasd", 18, "tosho", 20, "asdasdasd", 20000, 0.20, 2.5, LocalDateTime.of(2030, 5, 15, 12, 10), false);
        entityManager.persist(wizardDeposit);
        entityManager.getTransaction().commit();
    }
}
