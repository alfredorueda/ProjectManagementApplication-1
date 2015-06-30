package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

/**
 * CREADO POR MARIO ROMERO FERNANDEZ
 */

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Manager extends Employee {

    @Column
    private Double bonusSucces;

    @JsonIgnore
    @OneToMany(mappedBy = "manager")
    private Set<Project> projectSet = new HashSet<>();

    public Manager() {
    }

    public Double getBonusSucces() {
        return bonusSucces;
    }

    public void setBonusSucces(Double bonusSucces) {
        this.bonusSucces = bonusSucces;
    }

    public Set<Project> getProjects() {
        return projectSet;
    }

    public void setProjects(Set<Project> projects) {
        this.projectSet = projects;
    }

    @Override
    public String toString() {
        return super.toString() + "Manager{" +
                "bonusSucces=" + bonusSucces +
                '}';
    }
}
