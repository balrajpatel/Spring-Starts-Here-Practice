package config;

import beans.Parrot;
import beans.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Kiki");
        return p;
    }

    @Bean
    @Primary
    public Parrot parrot2() {
        Parrot p = new Parrot();
        p.setName("Miki");
        return p;
    }

    @Bean
    public Person person( Parrot parrot2) {
        Person p = new Person();
        p.setName("Jack Thomson");
        p.setParrot(parrot2);
        return p;
    }

    @Bean
    public Person person2(@Qualifier("parrot")Parrot p) {
        Person p2 = new Person();
        p2.setName("Jack");
        p2.setParrot(p);
        return p2;
    }

    /*
    Using the @Qualifier annotation,
you clearly mark your intention
to inject a specific bean from the
context
     */
}
