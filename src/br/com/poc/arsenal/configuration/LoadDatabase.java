package br.com.poc.arsenal.configuration;

import br.com.poc.arsenal.model.ArsenalModel;
import br.com.poc.arsenal.repository.ArsenalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ArsenalRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new ArsenalModel(1L,"Teste")));
            log.info("Preloading " + repository.save(new ArsenalModel(2L, "Teste2")));
        };
    }
}
