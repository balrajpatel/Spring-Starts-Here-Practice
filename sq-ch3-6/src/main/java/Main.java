import beans.Person;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person p1 = context.getBean("person",Person.class);
        System.out.println("Person's name "+ p1.getName());
        System.out.println("Person's parrot "+ p1.getParrot());
        Person p2 = context.getBean("person2",Person.class);
        System.out.println("Person's name "+ p2.getName());
        System.out.println("Person's parrot "+ p2.getParrot());
        //Same approach of this module works for stereotype annotation.
    }
}
/*
        Parameter-name injection works ONLY IF:
        1️⃣ Your code is compiled with the -parameters flag
        This flag tells Java:
        “Preserve method parameter names at runtime”

        Without it, Java converts:
        Person person(Parrot parrot2)

        into something like:
        Person person(Parrot arg0)

        So Spring sees:
        arg0 → Parrot
        ❌ No matching bean name → ambiguity → exception
 */
