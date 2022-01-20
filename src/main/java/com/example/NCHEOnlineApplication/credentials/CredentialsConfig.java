package com.example.NCHEOnlineApplication.credentials;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class CredentialsConfig {

    @Bean
    CommandLineRunner commandLineRunner(CredentialsRepository repository){
        return args-> {

            Credentials Harold = new Credentials(
                    "Harold",
                    "Mvula",
                    "haroldtrinity@gmail.com",
                    LocalDate.of(2002, 03, 18),
                    "MVULA2002"
            );

            Credentials Augustine = new Credentials(
                    "Augustine",
                    "Mvula",
                    "agustinemvula@gmail.com",
                    LocalDate.of(2009, 03, 18),
                    "MVULA2002"
            );

            Credentials Aubrey = new Credentials(
                    "Aubrey",
                    "Mvula",
                    "aubreytrinity@gmail.com",
                    LocalDate.of(2007, 03, 18),
                    "MVULA2002"
            );

            repository.saveAll(
                    List.of(Harold,Augustine,Aubrey)
            );
        };
    }
}

