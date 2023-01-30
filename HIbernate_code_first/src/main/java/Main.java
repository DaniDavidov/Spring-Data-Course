import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vehicles");
        EntityManager entityManager = emf.createEntityManager();
        Car car = new Car("Audi", new BigDecimal("19.5"), "diesel", 5);
        Truck truck = new Truck("scania", new BigDecimal("19.5"), "diesel", 2.5);

        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.persist(truck);

        entityManager.getTransaction().commit();
    }
}
