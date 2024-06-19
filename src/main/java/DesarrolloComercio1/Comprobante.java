package DesarrolloComercio1;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Comprobante {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column
    private LocalDateTime fecha;
    @ManyToOne
    private Cliente cliente;
    @OneToMany(
            mappedBy = "comprobante",
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<DetalleComprobante> detalles;

    public Comprobante() {
        this.detalles = new ArrayList();
        this.fecha = LocalDateTime.now();
    }

    public Comprobante(Cliente cliente) {
        this();
        this.cliente = cliente;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleComprobante> getDetalles() {
        return this.detalles;
    }

    public void setDetalles(List<DetalleComprobante> detalles) {
        this.detalles = detalles;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Comprobante that = (Comprobante)o;
            return Objects.equals(this.id, that.id) && Objects.equals(this.fecha, that.fecha) && Objects.equals(this.cliente, that.cliente) && Objects.equals(this.detalles, that.detalles);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.fecha, this.cliente, this.detalles});
    }

    public void agregarDetalle(Producto producto, Integer cantidad) {
        DetalleComprobante detalle = new DetalleComprobante(this, producto, cantidad);
        this.detalles.add(detalle);
    }
}