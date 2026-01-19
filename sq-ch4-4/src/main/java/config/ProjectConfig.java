package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import proxies.CommentNotificationProxy;
import proxies.EmailCommentNotificationProxy;
import repositories.CommentRepository;
import repositories.DBCommentRepository;
import services.CommentService;

@Configuration
public class ProjectConfig {
    @Bean
    CommentNotificationProxy commentNotificationProxy() {
        return new EmailCommentNotificationProxy();
    }
    @Bean
    CommentRepository commentRepository() {
        return new DBCommentRepository();
    }
    @Bean   // explicit wiring // since we instruct everything , no autowiring
    CommentService commentService() {   // will not create two instances,
        return new CommentService(commentNotificationProxy(),commentRepository());
    } // spring intercepts the method call and returns the existed bean from context

    /*
    @Bean
    CommentService commentService(commentNotificationProxy cN, commentRepository cR){
    return new CommentService(cN, cR);
    this will also work , in it spring inject the Dependency in the method paramter
     */
}
