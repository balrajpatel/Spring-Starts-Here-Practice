package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pkg1.Parrot;

@Configuration  // this defines class as spring configuration class
public class ProjectConfig {
    @Bean
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }
    /*By adding the @Bean annotation, we instruct Spring
to call this method when at context initialization and
add the returned value to the context.*/
}
