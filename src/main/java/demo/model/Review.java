package demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by poo2 on 06/07/2015.
 */
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Double valoration;

    @Column
    @NotNull
    private Date date;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Developer developer;

    @ManyToOne
    private Speciality speciality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValoration() {
        return valoration;
    }

    public void setValoration(Double valoration) {
        this.valoration = valoration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Review{" +
                ", startDate=" + date +
                ", valoration=" + valoration +
                ", id=" + id +
                '}';
    }
}

