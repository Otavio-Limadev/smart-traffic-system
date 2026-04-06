package com.smarttraffic.backend.config;

import com.smarttraffic.backend.model.Intersection;
import com.smarttraffic.backend.model.TrafficLight;
import com.smarttraffic.backend.repository.IntersectionRepository;
import com.smarttraffic.backend.repository.TrafficLightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(IntersectionRepository intRepo, TrafficLightRepository lightRepo) {
        return args -> {
            if (intRepo.count() == 0) {
                // Criando o cruzamento da Paulista
                Intersection paulista = new Intersection();
                paulista.setName("Av. Paulista x Al. Campinas");
                paulista.setCurrentCarCount(0);
                intRepo.save(paulista); // save primeiro cruzamento

                // Criando o semáforo para a Paulista
                TrafficLight lightPaulista = new TrafficLight();
                lightPaulista.setIntersection(paulista); // vinculado ao primeiro cruzamento
                lightPaulista.setState(TrafficLight.LightState.RED);
                lightRepo.save(lightPaulista);

                // Criando o cruzamento da Faria Lima
                Intersection fariaLima = new Intersection();
                fariaLima.setName("Av. Faria Lima x Av. JK");
                fariaLima.setCurrentCarCount(0);
                intRepo.save(fariaLima);

                // Criando o semáforo para a Faria Lima
                TrafficLight lightFaria = new TrafficLight();
                lightFaria.setIntersection(fariaLima);
                lightFaria.setState(TrafficLight.LightState.RED);
                lightRepo.save(lightFaria);

                System.out.println("Cruzamentos e semáforos criados.");
            }
        };
    }
}