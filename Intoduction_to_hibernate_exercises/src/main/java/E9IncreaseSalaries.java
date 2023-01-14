import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class E9IncreaseSalaries {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        List<Employee> resultList = entityManager.createQuery("SELECT e FROM Employee e" +
                        " WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing' or 'Information Services')", Employee.class)
                .getResultList();

        for (Employee employee : resultList) {
            BigDecimal multiplied = employee.getSalary().multiply(BigDecimal.valueOf(1.12));
            employee.setSalary(multiplied);
            entityManager.persist(employee);
            System.out.printf("%s %s (%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getSalary());
        }


        entityManager.getTransaction().commit();
    }
}
