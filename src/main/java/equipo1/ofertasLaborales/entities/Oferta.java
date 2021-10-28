package equipo1.ofertasLaborales.entities;

import equipo1.ofertasLaborales.Modalidad;
import equipo1.ofertasLaborales.TipoContrato;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * Entidad que gestiona la tabla ofertas de la base de datos
 */
@Entity
@Table(name = "Ofertas")
  public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="OfertaTecnologia",
            joinColumns={
            @JoinColumn(name="IdOferta", referencedColumnName = "id")
            },
            inverseJoinColumns= {
            @JoinColumn(name = "IdTecnologia", referencedColumnName = "id") })
    private Set<Tecnologia> tecnologias;

    // Resto de atributos
    private String empresa;
    private String descripcion;
    private Integer numeroVacantes;
    private String localidad;
    private Integer salarioMinimo;
    private Integer salarioMaximo;
    @Enumerated(EnumType.ORDINAL)
    private Modalidad modalidad;
    private Integer anyosExperiencia;
    private String titulacion;
    private Integer categoria;
    @Enumerated(EnumType.ORDINAL)
    private TipoContrato tipoContrato;
    private Date fechaPublicacion;
    private Boolean estadoProceso;


    // Constructores
    public Oferta() {
    }

    public Oferta(Long id, Set<Tecnologia> tecnologias, String empresa, String descripcion, Integer numeroVacantes,
                  String localidad, Integer salarioMinimo, Integer salarioMaximo, Modalidad modalidad,
                  Integer anyosExperiencia, String titulacion, Integer categoria, TipoContrato tipoContrato,
                  Date fechaPublicacion, Boolean estadoProceso) {
        this.id = id;
        this.tecnologias = tecnologias;
        this.empresa = empresa;
        this.descripcion = descripcion;
        this.numeroVacantes = numeroVacantes;
        this.localidad = localidad;
        this.salarioMinimo = salarioMinimo;
        this.salarioMaximo = salarioMaximo;
        this.modalidad = modalidad;
        this.anyosExperiencia = anyosExperiencia;
        this.titulacion = titulacion;
        this.categoria = categoria;
        this.tipoContrato = tipoContrato;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoProceso = estadoProceso;
    }

    // Setters y Getters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(Set<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumeroVacantes() {
        return numeroVacantes;
    }

    public void setNumeroVacantes(Integer numeroVacantes) {
        this.numeroVacantes = numeroVacantes;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(Integer salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public Integer getSalarioMaximo() {
        return salarioMaximo;
    }

    public void setSalarioMaximo(Integer salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public Integer getAnyosExperiencia() {
        return anyosExperiencia;
    }

    public void setAnyosExperiencia(Integer anyosExperiencia) {
        this.anyosExperiencia = anyosExperiencia;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Boolean getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(Boolean estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    //Tostring


    @Override
    public String toString() {
        return "Oferta{" +
                "id=" + id +
                ", tecnologias=" + tecnologias +
                ", empresa='" + empresa + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numeroVacantes=" + numeroVacantes +
                ", localidad='" + localidad + '\'' +
                ", salarioMinimo=" + salarioMinimo +
                ", salarioMaximo=" + salarioMaximo +
                ", modalidad=" + modalidad +
                ", anyosExperiencia=" + anyosExperiencia +
                ", titulacion='" + titulacion + '\'' +
                ", categoria=" + categoria +
                ", tipoContrato=" + tipoContrato +
                ", fechaPublicacion=" + fechaPublicacion +
                ", estadoProceso=" + estadoProceso +
                '}';
    }
}