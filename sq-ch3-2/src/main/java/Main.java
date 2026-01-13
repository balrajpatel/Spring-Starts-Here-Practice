import beans.Parrot;
import beans.Person;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person.getName());
        System.out.println("Person's Parrot: "+ person.getParrot());
    }


    /*
    why this approach is not desired
    you don’t have the option to make the field final (see next code snippet), and
    this way, make sure no one can change its value after initialization:
            private final Parrot parrot;
            }
            This doesn’t compile. You cannot define
            a final field without an initial value.
     */
}
