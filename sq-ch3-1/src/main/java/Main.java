import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pkg.Parrot;
import pkg.Person;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person = context.getBean("person",Person.class);
        System.out.println(person.getName());
        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());
        System.out.println("Person's Parrot: " + person.getParrot());

        Person person2 = context.getBean("person2",Person.class);
        System.out.println(person2.getName());
        System.out.println("Person's Person2: " + person2.getParrot());

    }
}
