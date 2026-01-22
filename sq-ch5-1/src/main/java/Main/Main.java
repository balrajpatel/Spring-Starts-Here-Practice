package Main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService = context.getBean("commentService",CommentService.class);
        CommentService commentService2 = context.getBean("commentService",CommentService.class);
        boolean b = commentService2==commentService;
        System.out.println(b);
    }
}
