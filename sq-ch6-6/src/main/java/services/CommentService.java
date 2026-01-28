package services;

import annotations.ToLog;
import model.Comment;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());
    @ToLog
    public String publishComment(Comment comment) {
        logger.info("Publishing comment: "+comment.getText());
        return "SUCCESS";
    }

    public String deleteComment(Comment comment) {
        logger.info("Deleting comment: "+comment.getText());
        return "SUCCESS";
    }
    public String editComment(Comment comment) {
        logger.info("Editing comment: "+comment.getText());
        return "SUCCESS";
    }
}
