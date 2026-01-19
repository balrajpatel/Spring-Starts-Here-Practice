package repositories;

import model.Comment;
import org.springframework.stereotype.Component;

@Component
public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing Comment: " + comment.getComment());
    }
}
/*

    @Repository adds exception translation
        This is NOT just documentation.
        Spring:
        Catches persistence-specific exceptions (e.g. SQLException)
        Translates them into Spring’s unchecked exceptions:
 */
