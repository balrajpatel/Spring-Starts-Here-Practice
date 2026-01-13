package beans;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Jiki";
    public String getName() {
        return name;
    }
    public String toString(){
        return getName();
    }

}
