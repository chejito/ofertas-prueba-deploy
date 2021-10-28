package equipo1.ofertasLaborales.controller;

import equipo1.ofertasLaborales.entities.Tecnologia;
import equipo1.ofertasLaborales.repositories.TecnologiaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class TecnologiaController {

    private final Logger log = LoggerFactory.getLogger(TecnologiaController.class);

    private TecnologiaRepository tecnologiaRepository;

    public TecnologiaController(TecnologiaRepository tecnologiaRepository) {
        this.tecnologiaRepository = tecnologiaRepository;
    }
        /**
         * Buscar todas las tecnologias en BBDD
         */

        @GetMapping("/api/tecnologias")
        public List<Tecnologia> findAll() {
            return tecnologiaRepository.findAll();
        }

    /**
     * Buscar tecnologias según id
     * Request
     * Response
     */
    @GetMapping("/api/tecnologias/{id}")
    public ResponseEntity<Tecnologia> findById(@PathVariable Long id) {
        Optional<Tecnologia> tecnologiaOpt = tecnologiaRepository.findById(id);
        if (tecnologiaOpt.isPresent()) {
            return ResponseEntity.ok(tecnologiaOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crear tecnologia nueva en la bbdd.
     *
     * @param tecnologia
     * @return
     */
    @PostMapping("/api/tecnologias")
    public ResponseEntity<Tecnologia> create(@RequestBody Tecnologia tecnologia) {
        if(tecnologia.getId() != null) {
            log.warn("Intentando crear una tecnologia con id");
            return ResponseEntity.badRequest().build();
        }

        Tecnologia result = tecnologiaRepository.save(tecnologia);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar una tecnologia en la bbdd.
     *
     * @param tecnologia
     * @return
     */
    @ApiIgnore
    @PutMapping("/api/tecnologias")
    public ResponseEntity<Tecnologia> update(@RequestBody Tecnologia tecnologia) {
        if (tecnologia.getId() == null) {
            log.warn("Intentando actualizar una tecnologia inexistente");
            return ResponseEntity.badRequest().build();
        }
        if (!tecnologiaRepository.existsById(tecnologia.getId())) {
            log.warn("Intentando actualizar una tecnologia inexistente");
            return ResponseEntity.notFound().build();
        }

        Tecnologia result = tecnologiaRepository.save(tecnologia);
        return ResponseEntity.ok(result);
    }

    /**
     * Eliminar una tecnologia de la bbdd.
     *
     * @param id
     * @return
     */
    @ApiIgnore
    @DeleteMapping("/api/tecnologias/{id}")
    public ResponseEntity<Tecnologia> delete(@PathVariable Long id) {

        if (!tecnologiaRepository.existsById(id)) {
            log.warn("Intentando eliminar una tecnologia inexistente");
            return ResponseEntity.notFound().build();
        }

        tecnologiaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todas las tecnologias de la bbdd.
     * @return
     */
    @ApiIgnore
    @DeleteMapping("/api/tecnologias")
    public ResponseEntity<Tecnologia> deleteAll() {
        log.info("Petición REST para eliminar todas las tecnologias");
        tecnologiaRepository.deleteAll();

        return ResponseEntity.noContent().build();
    }
}
