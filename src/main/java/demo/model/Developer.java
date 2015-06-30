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

    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

    @JsonIgnore
    @ManyToMany(mappedBy="developerSet")
    private Set<Project> projectSet = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    private Set<Speciality> specialitiesSet = new HashSet<>();

    public Developer() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Project> getProjectSet() {
        return projectSet;
    }

    public void setProjectSet(Set<Project> projectSet) {
        this.projectSet = projectSet;
    }

    public Set<Speciality> getSpecialitiesSet() {
        return specialitiesSet;
    }

    public void setSpecialitiesSet(Set<Speciality> specialitiesSet) {
        this.specialitiesSet = specialitiesSet;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "category=" + category +
                "projects" + projectSet +
                '}';
    }
}
