package Main;

import model.Comment;
import proxies.CommentNotificationProxy;
import proxies.EmailCommentNotificationProxy;
import repositories.CommentRepository;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setText("Demo Comment");
        comment.setAuthor("John Doe");
        CommentNotificationProxy commentNotificationProxy = new EmailCommentNotificationProxy();
        CommentRepository commentRepository = new DBCommentRepository();
        CommentService commentService = new CommentService(commentRepository, commentNotificationProxy);
        commentService.pushComment(comment);
    }
}
