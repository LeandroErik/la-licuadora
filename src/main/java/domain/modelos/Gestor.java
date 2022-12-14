package domain.modelos;

import domain.Validaciones.GestorException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="gestor")
@Getter
@Setter
public class Gestor extends Persistente {

    @Column(name="nombre")
    @NotBlank
    private String nombre;

    @OneToMany(mappedBy = "gestor",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<ProductoBase> productos;

    @Column
    private boolean estaActivo;//Para la baja logica de la entidad.

    //En hibernate debe contener un contructor vacio...
    public Gestor(){}

    public Gestor(String nombre) {
        this.nombre = nombre;
        this.estaActivo = true;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(ProductoBase productoBase) throws GestorException {

        if(this.getProductos().contains(productoBase)){
            throw  new GestorException("ya esta incluida en la lista de productos del gestor",this,productoBase);
        }
        productos.add(productoBase);
        productoBase.setGestor(this);
    }

}
