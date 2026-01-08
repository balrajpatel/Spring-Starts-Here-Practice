package pkg1;

public class Parrot {
    private String name;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}




// never work inside java package directly,
//as the file goes into default package,
// working directly with default package is not a spring convention
/*
Problems:
❌ Spring Boot component scanning fails
❌ You cannot import default-package classes cleanly
❌ Maven + IDE tooling behaves unpredictably
❌ Real-world projects NEVER do this
 */
