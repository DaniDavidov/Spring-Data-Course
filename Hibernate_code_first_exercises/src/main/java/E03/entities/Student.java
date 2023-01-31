package E03.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "03_students")
public class Student extends Person {
    @Column(name = "average_grade", nullable = false)
    private double averageGrade;

    private String attendance;

    @ManyToMany
    @JoinTable(name = "students_courses",
    joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private Set<Course> courses;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, String phoneNumber, double averageGrade, String attendance) {
        super(firstName, lastName, phoneNumber);
        this.averageGrade = averageGrade;
        this.attendance = attendance;
    }
}
