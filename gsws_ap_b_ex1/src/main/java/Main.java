import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pkg1.Parrot;

public class Main {
    public static void main(String[] args) {
       //        var context = new AnnotationConfigApplicationContext();  // creates instance of spring context
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // make spring use the configuration class defined  by passing as param in instance of spring context.
        Parrot p2 = context.getBean(Parrot.class);
        System.out.println(p2.getName());
    }
}
