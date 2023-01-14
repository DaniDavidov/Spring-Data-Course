import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class E02ContainsEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        String[] searchFor = scanner.nextLine().split(" ");

        Long count = entityManager.createQuery("SELECT COUNT(e) FROM Employee e" +
                                                    " WHERE e.firstName = :firstName" +
                                                    " AND e.lastName = :lastName", Long.class)
                        .setParameter("firstName", searchFor[0])
                        .setParameter("lastName", searchFor[1])
                        .getSingleResult();

        String output = "";
        if (count > 0) {
            output = "Yes";
        } else {
            output = "No";
        }
        System.out.println(output);

        entityManager.getTransaction().commit();

    }
}
