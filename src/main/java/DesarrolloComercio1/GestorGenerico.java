package DesarrolloComercio1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GestorGenerico {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("commercePU");

    public GestorGenerico() {
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }

    }
}
