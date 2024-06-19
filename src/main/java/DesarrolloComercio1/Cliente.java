package DesarrolloComercio1;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Integer RUT;
    @Column
    private Integer edad;
    @ManyToMany
    @JoinTable(
            name = "Cliente_Producto",
            joinColumns = {@JoinColumn(
                    name = "cliente_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "producto_id"
            )}
    )
    private List<Producto> carrito = new ArrayList();

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, Integer RUT, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.RUT = RUT;
        this.edad = edad;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Integer getRUT() {
        return this.RUT;
    }

    public List<Producto> getCarrito() {
        return this.carrito;
    }

    public void setCarrito(List<Producto> carrito) {
        this.carrito = carrito;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Cliente cliente = (Cliente)o;
            return Objects.equals(this.id, cliente.id) && Objects.equals(this.nombre, cliente.nombre) && Objects.equals(this.apellido, cliente.apellido) && Objects.equals(this.RUT, cliente.RUT) && Objects.equals(this.edad, cliente.edad);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.nombre, this.apellido, this.RUT, this.edad});
    }
}
