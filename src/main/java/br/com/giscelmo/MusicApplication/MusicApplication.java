package br.com.giscelmo.MusicApplication;

import br.com.giscelmo.MusicApplication.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicApplication implements CommandLineRunner {
    private final Principal principal;

    public MusicApplication(Principal principal) {
        this.principal = principal;
    }

    public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        principal.executar();
    }
}
