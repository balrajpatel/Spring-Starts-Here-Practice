package Main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println("Before Comment Service instantiation");
        CommentService commentService = context.getBean(CommentService.class);
        CommentService commentService2 = context.getBean(CommentService.class);
        System.out.println("After Comment Service instantiation");
        boolean b = commentService2==commentService;
        System.out.println(b);

    }
}
