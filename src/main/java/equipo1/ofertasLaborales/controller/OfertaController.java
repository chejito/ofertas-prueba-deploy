package equipo1.ofertasLaborales.controller;

import equipo1.ofertasLaborales.entities.Oferta;
import equipo1.ofertasLaborales.repositories.OfertaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class OfertaController {

    private final Logger log = LoggerFactory.getLogger(OfertaController.class);

    private OfertaRepository ofertaRepository;

    public OfertaController(OfertaRepository ofertaRepository) {
        this.ofertaRepository = ofertaRepository;
    }

    /**
     * Buscar todas las ofertas en BBDD
     */
    @GetMapping("/api/ofertas")
    public List<Oferta> findAll() {
        return ofertaRepository.findAll();
    }

    /**
     * Buscar ofertas según id
     * Request
     * Response
     */

    @GetMapping("/api/ofertas/{id}")
    public ResponseEntity<Oferta> findById(@PathVariable Long id) {
        Optional<Oferta> ofertaOpt = ofertaRepository.findById(id);
        if (ofertaOpt.isPresent()) {
            return ResponseEntity.ok(ofertaOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crear oferta nueva en la bbdd.
     *
     * @param oferta
     * @return
     */
    @ApiIgnore
    @PostMapping("/api/ofertas")
    public ResponseEntity<Oferta> create(@RequestBody Oferta oferta) {
        if(oferta.getId() != null) {
            log.warn("Intentando crear una oferta con id");
            return ResponseEntity.badRequest().build();
        }

        Oferta result = ofertaRepository.save(oferta);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar una oferta en la bbdd.
     *
     * @param oferta
     * @return
     */
    @ApiIgnore
    @PutMapping("/api/ofertas")
    public ResponseEntity<Oferta> update(@RequestBody Oferta oferta) {
        if (oferta.getId() == null) {
            log.warn("Intentando actualizar una oferta inexistente");
            return ResponseEntity.badRequest().build();
        }
        if (!ofertaRepository.existsById(oferta.getId())) {
            log.warn("Intentando actualizar una oferta inexistente");
            return ResponseEntity.notFound().build();
        }

        Oferta result = ofertaRepository.save(oferta);
        return ResponseEntity.ok(result);
    }

    /**
     * Eliminar una oferta de la bbdd.
     * 
     * @param id
     * @return
     */
    @ApiIgnore
    @DeleteMapping("/api/ofertas/{id}")
    public ResponseEntity<Oferta> delete(@PathVariable Long id) {

        if (!ofertaRepository.existsById(id)) {
            log.warn("Intentando eliminar una oferta inexistente");
            return ResponseEntity.notFound().build();
        }

        ofertaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todas las ofertas de la bbdd.
     * @return
     */
    @ApiIgnore
    @DeleteMapping("/api/ofertas")
    public ResponseEntity<Oferta> deleteAll() {
        log.info("Petición REST para eliminar todas las ofertas");
        ofertaRepository.deleteAll();

        return ResponseEntity.noContent().build();
    }
}
