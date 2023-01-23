package de.lubowiecki.productmanagement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Optional;

public class ProductRepository {

    // Name der PersistenceUnit aus der persistence.xml
    // Factory Konfiguriert die Erzeugung der EntityManager
    public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public void save(Product product) {

        if(product.getId() > 0L) {
            // UPDATE
        }
        else {
            insert(product);
        }
    }

    private void insert(Product product) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin(); // Transaktion starten
        em.persist(product);
        em.getTransaction().commit(); // Alle Befehle der Transaktion an die Datenbank übertragen
    }

    public Optional<Product> find(long id) {
        EntityManager em = getEntityManager();
        Product product = em.find(Product.class, id);
        if(product != null) {
            em.detach(product);
            return Optional.of(product);
        }
        return Optional.empty();
    }
}
