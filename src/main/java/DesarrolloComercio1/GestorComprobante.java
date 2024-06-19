package DesarrolloComercio1;

import jakarta.persistence.EntityManager;

public class GestorComprobante {
    public GestorComprobante() {
    }

    public void createComprobante(Cliente cliente) {
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Comprobante comprobante = new Comprobante(cliente);
        manager.persist(comprobante);
        manager.getTransaction().commit();
        manager.close();
    }
}
