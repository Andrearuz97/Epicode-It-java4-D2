package it.epicode.be.godfather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements CommandLineRunner {

	@Autowired
	private OrderCommandRunner orderCommandRunner;

	@Override
	public void run(String... args) throws Exception {
		// Al momento dell'avvio dell'applicazione, esegui il codice per l'ordine
		orderCommandRunner.run();
	}
}
