package gm.zona_fit.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer membresia;

    @Override
    public String toString() {
        return "Id: \"" + this.id + "\" Nombre: \"" + this.nombre + "\" Apellido: \"" + this.apellido + "\" Membresia: \"" + this.membresia + "\"";
    }
}
