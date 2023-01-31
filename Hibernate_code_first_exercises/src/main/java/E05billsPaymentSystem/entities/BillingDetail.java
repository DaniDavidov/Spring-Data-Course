package E05billsPaymentSystem.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "05_billing_details")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class BillingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(insertable = false, updatable = false)
    private String type;

    @Column(nullable = false)
    private String number;

    @ManyToMany(mappedBy = "billingDetails", targetEntity = User.class)
    private Set<User> users;

    public BillingDetail() {
    }

    public BillingDetail(String type, String number) {
        this.type = type;
        this.number = number;
        this.users = new LinkedHashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
