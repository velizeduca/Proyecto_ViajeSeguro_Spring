package com.viajes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.viajes.service.CiudadService;



@SpringBootApplication
public class ViajeSeguroSpringBootApplication implements CommandLineRunner {

	@Autowired
	private CiudadService repoCiudad;
	
	public static void main(String[] args) {
		SpringApplication.run(ViajeSeguroSpringBootApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("================================");
		System.out.println("LISTADO DE CIUDADES");
		System.out.println("================================");

		repoCiudad.listar().forEach(ciudad -> {
			System.out.println(
				ciudad.getIdCiudad() + " - " +
				ciudad.getNombre() + " - " +
				ciudad.getEstado()
			);
		});
}
		
	
	
}
