package de.lubowiecki.productmanagement;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "products") // Name der Tabelle
public class Product implements Serializable { // POJO - gibt es keine @Table-Annotation, wird die Tabelle nach der Klasse benannt

    @Id
    @GeneratedValue // ID soll automatisch vergeben werden
    private long id;

    // Wird die Spalte in @Column nicht umbenannt, dann ist der name gleich dem Eigenschaftsnamen
    // JavaDatentypen werden automatisch auf passende DB-Datentypen verändert
    @Column(length = 100, unique = true)
    private String name;

    @Column(length = 500)
    private String description;

    private double price;

    public Product() {
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
