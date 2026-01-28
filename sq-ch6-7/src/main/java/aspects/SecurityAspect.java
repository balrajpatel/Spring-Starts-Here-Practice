package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Order(1)
@Component
public class SecurityAspect {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    @Around(value = "@annotation(annotations.ToLog)")
    public Object securitylog(ProceedingJoinPoint joinPoint ) throws Throwable {
        logger.info("Security Aspect: Calling the intercepted method ");
        Object result = joinPoint.proceed();
        logger.info("Security Aspect: Method executed and returned " + result);
        return result;
    }
}
