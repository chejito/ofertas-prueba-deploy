package equipo1.ofertasLaborales.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidad que gestiona la tabla tecnologías de la base de datos
 */
@Entity
@Table(name = "tecnologias")
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Resto de atributos
    private String nombre;


    // Constructores
    public Tecnologia() {
    }

    public Tecnologia(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Setters y Getters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // ToString


    @Override
    public String toString() {
        return "Tecnologia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
