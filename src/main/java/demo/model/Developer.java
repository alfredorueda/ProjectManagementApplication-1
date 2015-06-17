package demo.model;

import javax.persistence.*;

/**
 * CREADO POR MARIO ROMERO FERNANDEZ
 */

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Developer extends Employee {

    @Enumerated(EnumType.STRING)
    private Category category;

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

        String developer = super.toString();

        return developer + "Developer{" +
                "category=" + category +
                '}';
    }

}
