package Main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.CommentRepository;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService = context.getBean(CommentService.class);
        UserService userService = context.getBean(UserService.class);
        CommentRepository commentServiceRepo = commentService.getRepo();
        CommentRepository userServiceRepo = userService.getRepo();
        boolean b = commentServiceRepo == userServiceRepo;
        System.out.println(b);
        System.out.println(userServiceRepo+ " " + commentServiceRepo);
        /*
        A singleton bean in the Spring Framework is a bean for which only one instance
        is created per Spring IoC container, and the same instance is shared whenever the bean is requested.

        The IoC container in the Spring Framework is the core component that creates,
        manages, and injects objects (beans) and controls their entire lifecycle.


        What is an IoC container?
            In the Spring Framework, an IoC container is typically an ApplicationContext.
            Example:
            ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
            👉 This context is one IoC container.

            2️⃣ What happens with a singleton bean?
            @Component
            public class CommentService {
            }
            Spring creates exactly one CommentService object inside this container.
            Every request returns the same object reference.
            CommentService a = context.getBean(CommentService.class);
            CommentService b = context.getBean(CommentService.class);
            System.out.println(a == b);  // true
            ✔ Same instance.

            🧠 Why “per container” matters (VERY IMPORTANT)
            Case 1️⃣: Single IoC container
            ApplicationContext (Container 1)
             └── CommentService  →  ONE object
            ✔ Singleton = one instance

            Case 2️⃣: Multiple IoC containers
            ApplicationContext c1 =
                new AnnotationConfigApplicationContext(AppConfig.class);
            ApplicationContext c2 =
                new AnnotationConfigApplicationContext(AppConfig.class);

            ApplicationContext c1
             └── CommentService → instance A

            ApplicationContext c2
             └── CommentService → instance B
            c1.getBean(CommentService.class)
            !=
            c2.getBean(CommentService.class);

            ❗ Now there are TWO instances, because there are two containers.
            👉 Singleton is NOT global across the JVM.


                Spring Container
                Conceptual term
                Refers to the component that:
                Creates beans
                Injects dependencies
                Manages lifecycle & scopes
                👉 It describes what it does, not a concrete class.

                🔹 Spring Context (ApplicationContext)
                Concrete implementation of the Spring container
                Most commonly used IoC container in real applications

                The Spring container is the general concept of an IoC manager, while ApplicationContext is the most commonly used implementation of that container.
         */
    }
}
