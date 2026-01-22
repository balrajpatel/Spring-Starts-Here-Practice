package Main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        /*
        Eager instantiation is the process where the Spring IoC container creates and initializes beans as soon as the container is started.
        In the Spring Framework:
            Singleton beans → Eagerly instantiated by default
            Prototype beans → Lazily instantiated by default
         */
    }
}
