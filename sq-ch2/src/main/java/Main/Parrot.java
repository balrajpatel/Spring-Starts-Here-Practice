package Main;    //this is used as basePackage in ComponentScan

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component     //instruct to Which classes to add an instance to its context
// it instructs spring to creat an object of that class (ctor is called) and add in its context
public class Parrot {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @PostConstruct  // it instructs spring to execute it just after the ctor is called (ctor used to create obj instance)
    //used to execute some instructions just after obj creation
    public void init() {
        this.name = "Kiki";
    }
}
