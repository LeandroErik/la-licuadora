package domain.modelos.personalizacion;

import domain.modelos.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_personalizacion")
@Getter
@Setter
public class TipoPersonalizacion extends Persistente {

    @Column(name = "nombre_tipo")
    private String nombreTipo;

}
