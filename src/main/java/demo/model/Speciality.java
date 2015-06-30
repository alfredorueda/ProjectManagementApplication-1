package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poo2 on 25/06/2015.
 */
@Entity
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    @JsonIgnore
    @ManyToMany(mappedBy = "specialitiesSet")
    private Set<Developer> developerSet = new HashSet<>();

    @Column
    @JsonIgnore
    @ManyToMany
    private Set<Project> projectSet = new HashSet<>();

    public Speciality() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Developer> getDeveloperSet() {
        return developerSet;
    }

    public void setDeveloperSet(Set<Developer> developerSet) {
        this.developerSet = developerSet;
    }

    public Set<Project> getProjectSet() {
        return projectSet;
    }

    public void setProjectSet(Set<Project> projectSet) {
        this.projectSet = projectSet;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
