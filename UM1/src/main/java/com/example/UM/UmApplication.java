package com.example.UM;

import com.example.UM.entidades.Alumno;
import com.example.UM.entidades.Profesor;
import com.example.UM.enumeraciones.Especialidades;
import com.example.UM.enumeraciones.Titulos;
import com.example.UM.repositorios.AlumnoRepository;
import com.example.UM.repositorios.PersonaRepository;
import com.example.UM.repositorios.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class UmApplication {
	private static final Logger logger = LoggerFactory.getLogger(UmApplication.class);

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private ProfesorRepository profesorRepository;

	@Autowired
	private AlumnoRepository alumnoRepository;

	public static void main(String[] args) {
		SpringApplication.run(UmApplication.class, args);
		System.out.println("funcionando");
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository,
						   AlumnoRepository alumnoRepository,
						   ProfesorRepository profesorRepository) {
		return args -> {
			// Creo un objeto alumno
			Profesor pro1 = Profesor.builder()
					.nombre("Alberto")
					.nombre("Cortez")
					.fechaIngreso(LocalDate.of(2022, 1, 1))
					.cantHijos(2)
					.titulo(Titulos.MASTER)
					.sueldo(new BigDecimal("123.45"))
					.build();

			// Lo grabo a través del repositorio de Spring
			profesorRepository.save(pro1);

			Profesor pro2 = Profesor.builder()
					.nombre("Daniel")
					.nombre("Quinteros")
					.fechaIngreso(LocalDate.of(2022, 1, 1))
					.cantHijos(2)
					.titulo(Titulos.MASTER)
					.sueldo(new BigDecimal("123.45"))
					.build();


			// Lo grabo a través del repositorio de Spring
			profesorRepository.save(pro2);

			Alumno al1 = Alumno.builder()
					.nombre("Alma")
					.apellido("Quinteros")
					.legajo(62000)
					.especialidad(Especialidades.BACHILLER)
					.build();

			// Lo grabo a través del repositorio de Spring
			alumnoRepository.save(al1);

			Alumno al2 = Alumno.builder()
					.nombre("Vale")
					.apellido("Artola")
					.legajo(62001)
					.especialidad(Especialidades.BACHILLER)
					.build();

			// Lo grabo a través del repositorio de Spring
			alumnoRepository.save(al2);

		};

	}

	;
}
