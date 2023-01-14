import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class E04EmployeesFromDepartment {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        String departmentName = "Research and Development";

        entityManager.createQuery("SELECT e FROM Employee e" +
                        " WHERE e.department.name = :departmentName" +
                        " ORDER BY e.salary ASC, e.id ASC", Employee.class)
                .setParameter("departmentName", departmentName)
                .getResultStream().forEach(employee -> System.out.printf("%s %s from %s - %.2f%n",
                        employee.getFirstName(), employee.getLastName(), employee.getDepartment().getName(), employee.getSalary()));


        entityManager.getTransaction().commit();
    }
}
