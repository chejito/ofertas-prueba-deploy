package equipo1.ofertasLaborales.repositories;

import equipo1.ofertasLaborales.entities.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que permite ejecutar consultas para la entidad Tecnologia
 * a través de JPA en la base de datos.
 */
@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Long> {
}
