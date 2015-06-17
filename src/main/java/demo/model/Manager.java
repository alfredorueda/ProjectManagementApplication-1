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
    private Double bonusSucces;

    @OneToMany(mappedBy = "manager")
    private Set<Project> projects = new HashSet<>();

    public Manager() {
    }

    public Double getBonusSucces() {
        return bonusSucces;
    }

    public void setBonusSucces(Double bonusSucces) {
        this.bonusSucces = bonusSucces;
    }

    @Override
    public String toString() {
        return super.toString() + "Manager{" +
                "bonusSucces=" + bonusSucces +
                '}';
    }

}
