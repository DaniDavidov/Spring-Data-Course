package E03.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "03_teachers")
public class Teacher extends Person {
    @Column(nullable = false)
    private String email;

    @Column(name = "salary_per_hour", nullable = false)
    private double salaryPerHour;

    @OneToMany(mappedBy = "teacher", targetEntity = Course.class)
    private Set<Course> courses;

    public Teacher() {
        super();
    }

    public Teacher(String firstName, String lastName, String phoneNumber, String email, double salaryPerHour) {
        super(firstName, lastName, phoneNumber);
        this.email = email;
        this.salaryPerHour = salaryPerHour;
    }
}
