package demo.model;

import javax.persistence.*;
import java.util.*;

/**
 * CREADO POR MARIO ROMERO FERNANDEZ
 */

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Developer extends Employee {

    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column
    @ManyToMany(mappedBy="developers")
    private Set<Project> projects = new HashSet<>();

    public Set<Project> getProject() {
        return projects;
    }

    public void setProject(Set<Project> project) {
        this.projects = project;
    }

    public Developer() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString() + "Developer{" +
                "category=" + category +
                '}';
    }
}