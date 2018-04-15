package hello;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerInterceptor {
    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) && execution(public * *(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log("before " + pjp.toShortString());
        Object proceed = pjp.proceed();
        log("after...");
        return proceed;
    }

    private void log(String s){
        //TODO logger使いましょう
        System.out.println(s);
    }
}
