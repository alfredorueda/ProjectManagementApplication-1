package demo.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Manager extends Employee {

    private Double bonusSucces;

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
