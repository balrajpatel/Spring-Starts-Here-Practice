package beans;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Kiki";
    public String getName() {
        return name;
    }
    public String toString(){
        return name;
    }

}
