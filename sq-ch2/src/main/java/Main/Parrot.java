package Main;    //this is used as basePackage in ComponentScan

import org.springframework.stereotype.Component;
@Component     //instruct to Which classes to add an instance to its context
public class Parrot {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
