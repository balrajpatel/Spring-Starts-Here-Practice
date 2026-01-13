package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Kiki";
    private Person person ;
    @Autowired
    public Parrot(Person person) {
        this.person = person;
    }
}
