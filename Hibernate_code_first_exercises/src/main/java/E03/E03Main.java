package E03;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class E03Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_relate");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();


        entityManager.getTransaction().commit();
    }
}
