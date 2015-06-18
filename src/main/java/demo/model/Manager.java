package demo.model;

import javax.persistence.*;
import java.util.*;

/**
 * CREADO POR MARIO ROMERO FERNANDEZ
 */

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Manager extends Employee {
    @Column
    private double bonusSuccess;

    @OneToMany(mappedBy="manager")
    private Set<Project> projects = new HashSet<>();

    public Manager() {
    }

    public double getBonusSuccess() {
        return bonusSuccess;
    }

    public void setBonusSuccess(double bonusSuccess) {
        this.bonusSuccess = bonusSuccess;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return super.toString() + "Manager{" +
                "bonusSuccess=" + bonusSuccess +
                ", projects=" + projects +
                '}';
    }
}