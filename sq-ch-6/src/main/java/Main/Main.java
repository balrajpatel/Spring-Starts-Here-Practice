package Main;

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Comment comment = new Comment();
        comment.setAuthor("John Doe");
        comment.setComment("Demo Comment");
        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }

    /*
    @Service and @Repository are specialized stereotype annotations that extend @Component.
    They behave the same for dependency injection, but @Repository additionally enables persistence exception translation.
     */
}
