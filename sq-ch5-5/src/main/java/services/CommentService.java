package services;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    public CommentService() {
        System.out.println("CommentService constructor");
    }
}
