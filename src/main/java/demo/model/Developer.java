package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * CREADO POR MARIO ROMERO FERNANDEZ
 */

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Developer extends Employee {

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column
    @JsonIgnore
    @ManyToMany(mappedBy="developerSet")
    private Set<Project> projectSet = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "developerSet")
    private Set<Speciality> specialitiesSet = new HashSet<>();

    public Developer() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Project> getProjects() {
        return projectSet;
    }

    public void setProjects(Set<Project> projects) {
        this.projectSet = projects;
    }

    public Set<Speciality> getSpecialitiesSet() {
        return specialitiesSet;
    }

    public void setSpecialitiesSet(Set<Speciality> specialitiesSet) {
        this.specialitiesSet = specialitiesSet;
    }

    @Override
    public String toString() {
        return super.toString()+"Developer{" +
                "category=" + category +
                '}';
    }
}
