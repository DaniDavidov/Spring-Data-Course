import entities.Town;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;

public class E01ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Query fromTown = entityManager.createQuery("SELECT t FROM Town t", Town.class);
        List<Town> resultList = fromTown.getResultList();

        for (Town town : resultList) {
            String name = town.getName();
            if (name.length() <= 5) {
                String toUpper = name.toUpperCase(Locale.ROOT);
                town.setName(toUpper);

                entityManager.persist(town);
            } else {
                entityManager.detach(town);
            }
        }

        entityManager.getTransaction().commit();

    }
}
