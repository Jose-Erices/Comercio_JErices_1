package DesarrolloComercio1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class DetalleComprobante {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @ManyToOne
    private Comprobante comprobante;
    @ManyToOne
    private Producto producto;
    @Column
    private Integer cantidad;

    public DetalleComprobante() {
    }

    public DetalleComprobante(Comprobante comprobante, Producto producto, Integer cantidad) {
        this.comprobante = comprobante;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Comprobante getComprobante() {
        return this.comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            DetalleComprobante that = (DetalleComprobante)o;
            return Objects.equals(this.id, that.id) && Objects.equals(this.comprobante, that.comprobante) && Objects.equals(this.producto, that.producto) && Objects.equals(this.cantidad, that.cantidad);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.comprobante, this.producto, this.cantidad});
    }
}
