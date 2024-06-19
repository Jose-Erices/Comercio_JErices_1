package DesarrolloComercio1;

import jakarta.persistence.EntityManager;
import java.util.List;

public class GestorClientes {
    public GestorClientes() {
    }

    public void create(String nombre, String apellido, Integer RUT, Integer edad) {
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Cliente cliente = new Cliente(nombre, apellido, RUT, edad);
        manager.persist(cliente);
        manager.getTransaction().commit();
        manager.close();
    }

    public List<Cliente> readAll() {
        EntityManager manager = GestorGenerico.getEntityManager();
        List<Cliente> lista = manager.createQuery("From Cliente", Cliente.class).getResultList();
        manager.close();
        return lista;
    }
}
