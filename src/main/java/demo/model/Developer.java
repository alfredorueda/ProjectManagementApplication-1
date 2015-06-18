package demo.model;

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

    @ManyToMany(mappedBy = "developer")
    private Set<Project> projects = new HashSet<>();

    public Developer() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {

        String developer = super.toString();

        return developer + "Developer{" +
                "category=" + category +
                '}';
    }

}
