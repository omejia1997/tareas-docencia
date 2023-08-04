package ec.edu.espe.gpr.docencia.tareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class TareasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TareasApplication.class, args);
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Guayaquil"));
	}

}
