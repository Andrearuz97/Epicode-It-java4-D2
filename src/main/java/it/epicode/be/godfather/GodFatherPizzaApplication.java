package it.epicode.be.godfather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "it.epicode.be.godfather")
public class GodFatherPizzaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GodFatherPizzaApplication.class, args);

		GestioneMenu gestioneMenu = context.getBean(GestioneMenu.class);
		gestioneMenu.stampaMenu();
		gestioneMenu.testTopping();
	}

}
