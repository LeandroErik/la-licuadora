package domain.modelos;


import domain.modelos.carrito.CarritoDeCompra;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "comprador")
@Getter
@Setter
public class Comprador extends Persistente {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoDeDocumento")
    private TipoDocumento tipoDocumento;

    @Column(name = "numeroDeDocumento")
    private String nroDocumento;

    @ElementCollection
    @CollectionTable(name = "comprador_telefono", joinColumns = @JoinColumn(name = "comprador_id"))
    @Column(name = "telefono")
    private Set<String> telefonos;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "carritoDeCompra_id", referencedColumnName = "id")
    private CarritoDeCompra carritoDeCompra;

    public Comprador() {
        this.telefonos = new LinkedHashSet<>();
    }
}