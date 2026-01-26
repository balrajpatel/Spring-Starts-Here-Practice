package Main;

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
         Logger logger = Logger.getLogger(Main.class.getName());
         var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
         Comment comment = new Comment();
         comment.setText("Demo comment");
         comment.setAuthor("John Doe");
         CommentService commentService = context.getBean(CommentService.class);
         String result = commentService.publishComment(comment);
         logger.info(result);
    }
}
