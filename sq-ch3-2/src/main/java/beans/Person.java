package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class Person {
    private String name;
    @Autowired
    private Parrot parrot;
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
    public Parrot getParrot() {
        return parrot;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @PostConstruct
    public void init() {
        setName("Jack Thomson");
    }
}
