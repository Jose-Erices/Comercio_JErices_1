package DesarrolloComercio1;

import jakarta.persistence.EntityManager;
import java.util.List;

public class GestorProducto {
    public GestorProducto() {
    }

    public void create(String nombre, Integer precio, Integer stock) {
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Producto producto = new Producto(nombre, precio, stock);
        manager.persist(producto);
        manager.getTransaction().commit();
        manager.close();
    }

    public List<Producto> readAll() {
        EntityManager manager = GestorGenerico.getEntityManager();
        List<Producto> lista = manager.createQuery("FROM Producto", Producto.class).getResultList();
        manager.close();
        return lista;
    }

    public void updatePrecio(Integer productoId, Integer nuevoPrecio) {
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Producto producto = (Producto)manager.find(Producto.class, productoId);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
        }

        manager.getTransaction().commit();
        manager.close();
    }
}
