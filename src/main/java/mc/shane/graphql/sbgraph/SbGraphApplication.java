package mc.shane.graphql.sbgraph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SbGraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbGraphApplication.class, args);
	}
}
