package hello.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import hello.Greeting;
import org.springframework.validation.annotation.Validated;
import hello.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class RestGreetingController {

    @Autowired
    private GreetingService greetingService;

    @RequestMapping("/rest/greeting")
    public List<Greeting> greeting() {
        return greetingService.all();
    }

    @RequestMapping("/rest/greeting/{id}")
    public Greeting greeting(@PathVariable long id) {
        return greetingService.get(id);
    }

    @RequestMapping(value = "/rest/greeting", method=POST)
    public String greetingSubmit(@Validated Greeting greeting) {
        greetingService.save(greeting);
        return "{ \"result\" : \"success\" }";
    }
}