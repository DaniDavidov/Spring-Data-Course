import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class E06AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("SELECT a FROM Address a" +
                                    " ORDER BY a.employees.size DESC", Address.class)
                        .getResultStream()
                        .limit(10)
                        .forEach(address -> System.out.printf("%s, %s - %d%n",
                                        address.getText(), address.getTown().getName(), address.getEmployees().size()));

        entityManager.getTransaction().commit();
    }
}
