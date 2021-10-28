package equipo1.ofertasLaborales.repositories;

import equipo1.ofertasLaborales.entities.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que permite ejecutar consultas para la entidad Oferta
 * a través de JPA en la base de datos.
 */
@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long> {
}
