package Main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println("Before CommentService instance created");
        CommentService service = context.getBean(CommentService.class);
        System.out.println("After CommentService instance created");
    }
}
