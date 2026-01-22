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
    }
}
