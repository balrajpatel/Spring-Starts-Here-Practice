import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pkg1.*;
public class Main {
    public static void main(String[] args) {
       //        var context = new AnnotationConfigApplicationContext();  // creates instance of spring context
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // make spring use the configuration class defined  by passing as param in instance of spring context.
        Parrot p2 = context.getBean("parrot",Parrot.class);   //1st param is the name of the bean which we refer
        System.out.println(p2.getName());
        String name = context.getBean(String.class);
        System.out.println(name);
        Integer age = context.getBean(Integer.class);
        System.out.println(age);

        Parrot p3 = context.getBean("parrot2", Parrot.class);
        System.out.println(p3.getName());

        Parrot p4 = context.getBean("parrot3", Parrot.class);
        System.out.println(p4.getName());

        Parrot p5 = context.getBean("tio",Parrot.class);
        System.out.println(p5.getName());

        Parrot p6 = context.getBean("Rani",Parrot.class);
        System.out.println(p6.getName());

        Parrot p7 = context.getBean(Parrot.class);  // will return the primary bean instance among beans of same Parrot type.
        // primary bean act as a default choice for that type instance
        System.out.println(p7.getName());
    }
}
