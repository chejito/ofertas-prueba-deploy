package equipo1.ofertasLaborales;


import equipo1.ofertasLaborales.entities.Oferta;
import equipo1.ofertasLaborales.entities.Tecnologia;
import equipo1.ofertasLaborales.repositories.OfertaRepository;
import equipo1.ofertasLaborales.repositories.TecnologiaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.*;

@SpringBootApplication
public class OfertasLaboralesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OfertasLaboralesApplication.class, args);
		OfertaRepository ofertaRepository = context.getBean(OfertaRepository.class);
		TecnologiaRepository tecnologiaRepository = context.getBean(TecnologiaRepository.class);

		Tecnologia tecJava = new Tecnologia(null, "java");
		Tecnologia tecSpring = new Tecnologia(null, "spring");
		Tecnologia tecJS = new Tecnologia(null, "javascript");
		Tecnologia tecAngular = new Tecnologia(null, "angular");
		Tecnologia tecCSS = new Tecnologia(null, "CSS");
		Tecnologia tecPython = new Tecnologia(null, "Python");
		Tecnologia tecReact = new Tecnologia(null, "React");
		Tecnologia tecJavaScript = new Tecnologia(null, "JavaScript");

		Set<Tecnologia> tecnologias1 = new HashSet<>();
		Set<Tecnologia> tecnologias2 = new HashSet<>();
		Set<Tecnologia> tecnologias3 = new HashSet<>();
		Set<Tecnologia> tecnologias4 = new HashSet<>();
		Set<Tecnologia> tecnologias5 = new HashSet<>();

		tecnologias1.add(tecJava);
		tecnologias1.add(tecSpring);
		tecnologias2.add(tecJS);
		tecnologias2.add(tecAngular);
		tecnologias3.add(tecCSS);
		tecnologias3.add(tecPython);
		tecnologias3.add(tecReact);
		tecnologias3.add(tecJavaScript);


		Date fecha=new Date (12/12/12) ;

		Oferta oferta1 = new Oferta(null, tecnologias1,"Orange","Comunicaciones",
				4,"Barcelona",12000,18000,
				Modalidad.Presencial,2,
				"Ingeniero",4,TipoContrato.Indefinido ,fecha,true) ;

		Oferta oferta2 = new Oferta(null, tecnologias2,"Vodafone","Comunicaciones",
				2,"Madrid",11000,16000,
				Modalidad.Remoto,1,
				"CFGS",4,TipoContrato.Practicas ,fecha,true);

		Oferta oferta3 = new Oferta(null, tecnologias3,"Movistar","Comunicaciones",
				2,"Zaragoza",14000,19000,
				Modalidad.Remoto,3,
				"CFGS",4,TipoContrato.Practicas ,fecha,true);

		Oferta oferta4 = new Oferta(null, tecnologias4,"Idealista","Comunicaciones",
				5,"Madrid",13000,20000,
				Modalidad.Remoto,1,
				"CFGS",4,TipoContrato.Practicas ,fecha,true);

		Oferta oferta5 = new Oferta(null, tecnologias5,"Alliance","Comunicaciones",
				2,"Andalucía",10000,15000,
				Modalidad.Remoto,1,
				"CFGS",4,TipoContrato.Practicas ,fecha,true);

		//System.out.println("Número de ofertas en base de datos: " + ofertaRepository.findAll().size());

		ofertaRepository.save(oferta1);
		ofertaRepository.save(oferta2);
		ofertaRepository.save(oferta3);
		ofertaRepository.save(oferta4);
		ofertaRepository.save(oferta5);

		System.out.println("Número de ofertas en base de datos: " + ofertaRepository.findAll().size());
		System.out.println("Número de tecnologías en base de datos: " + tecnologiaRepository.findAll().size());
//		System.out.println(ofertaRepository.findAll());
//
//		System.out.println("Oferta según id: " + ofertaRepository.findById(1L));
//		System.out.println("Oferta según id: " + ofertaRepository.findById(2L));

//		Optional<Oferta> ofertaRecuperada1 = ofertaRepository.findById(1L);
//		if (ofertaRecuperada1.isPresent()) {
//			Oferta ofertaParaUtilizar = ofertaRecuperada1.get();
//			System.out.println("Tecnologías de la oferta con id " + ofertaParaUtilizar.getId() + ": "
//					+ ofertaParaUtilizar.getTecnologias().toString());
//		}
//
//		Optional<Oferta> ofertaRecuperada2 = ofertaRepository.findById(2L);
//		if (ofertaRecuperada2.isPresent()) {
//			Oferta ofertaParaUtilizar = ofertaRecuperada2.get();
//			System.out.println("Tecnologías de la oferta con id " + ofertaParaUtilizar.getId() + ": "
//					+ ofertaParaUtilizar.getTecnologias().toString());
//		}
//
//
	}

}
