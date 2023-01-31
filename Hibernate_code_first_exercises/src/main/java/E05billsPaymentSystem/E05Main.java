package E05billsPaymentSystem;

import E05billsPaymentSystem.entities.BankAccount;
import E05billsPaymentSystem.entities.BillingDetail;
import E05billsPaymentSystem.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class E05Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_relate");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        BillingDetail billingDetail = new BankAccount("asdasdas", "DSK", "dasdasdsa");
        entityManager.persist(billingDetail);
        User user = new User("Dani", "Davidov", "asdasdasd", "asdasdas");
        entityManager.persist(user);

        user.getBillingDetails().add(billingDetail);
        entityManager.persist(user);


        entityManager.getTransaction().commit();
    }
}
