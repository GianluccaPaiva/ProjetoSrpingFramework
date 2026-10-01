package br.com.spring.screenmatch;

import br.com.spring.screenmatch.principal.Principal;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	private final Principal principal;

	public ScreenmatchApplication(Principal principal) {
		this.principal = principal;
	}

	@Override
	public void run(String... args) throws Exception {
		principal.exibeMenu();
	}

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(ScreenmatchApplication.class, args);
	}
}
