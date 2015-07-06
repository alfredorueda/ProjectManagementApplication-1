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
    private Date startDate;

    @Column
    private Date endDate;

    @ManyToOne
    private Project projects;

    @ManyToOne
    private Developer developers;

    @ManyToOne
    private Manager managers;

    @ManyToOne
    private Speciality specialitys;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Project getProjects() {
        return projects;
    }

    public void setProjects(Project projects) {
        this.projects = projects;
    }

    public Developer getDevelopers() {
        return developers;
    }

    public void setDevelopers(Developer developers) {
        this.developers = developers;
    }

    public Manager getManagers() {
        return managers;
    }

    public void setManagers(Manager managers) {
        this.managers = managers;
    }

    public Speciality getSpecialitys() {
        return specialitys;
    }

    public void setSpecialitys(Speciality specialitys) {
        this.specialitys = specialitys;
    }

    @Override
    public String toString() {
        return "Review{" +
                "endDate=" + endDate +
                ", startDate=" + startDate +
                ", valoration=" + valoration +
                ", id=" + id +
                '}';
    }
}

