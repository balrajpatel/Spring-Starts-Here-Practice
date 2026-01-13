import Main.Parrot;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot parrot = new Parrot();
        parrot.setName("Kiki");
        Supplier<Parrot> supplier = () -> parrot;
        //defined Supplier to return parrot instance which we want to add in spring context
        context.registerBean("parrot1",Parrot.class,supplier);
        //4th param can omit, because its a var args, it helps to configure this  instance like making it primary;

        //registerBean approach works only on spring 5 and later

        Parrot parrot2 = context.getBean(Parrot.class);
                System.out.println(parrot2.getName());
    }
}
