package hello;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ ResourceNotFoundException.class })
    @ResponseBody
    public String handle(ResourceNotFoundException e){
        log("not found", e);
        return "something... ";
    }

    private void log(String s, Exception e){
        //TODO logger使いましょう
        System.out.println(s);

        e.printStackTrace();
    }
}
