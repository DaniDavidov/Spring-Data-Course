package E04hospitalDatabase.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "04_medicaments")
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "medicaments", targetEntity = Patient.class)
    private Set<Patient> patients;

    @ManyToMany(mappedBy = "medicaments", targetEntity = Visitation.class)
    private Set<Visitation> visitations;

    public Medicament() {
    }

    public Medicament(String name) {
        this.name = name;
        this.patients = new LinkedHashSet<>();
        this.visitations = new LinkedHashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }
}
