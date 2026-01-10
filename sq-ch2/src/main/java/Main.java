import config.projectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import Main.Parrot;
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(projectConfig.class);
        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());
    }
}
