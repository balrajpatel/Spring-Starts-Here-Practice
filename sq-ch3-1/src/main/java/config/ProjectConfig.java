package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pkg.Parrot;
import pkg.Person;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }


    //Wiring Beans
    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("Jack");
        person.setParrot(parrot());
        return person;
    }

    //Injecting Beans
    @Bean
    public Person person2(Parrot parrot) {
        Person person = new Person();
        person.setName("Joe");
        person.setParrot(parrot);
        return person;
    }

}
