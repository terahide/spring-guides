package hello.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import hello.Greeting;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class RestGreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/rest/greeting")
    public List<Greeting> greeting() {
        List<Greeting> greetings = new ArrayList<>();
        greetings.add(new Greeting(counter.incrementAndGet(),
                String.format(template, "world")));
        return greetings;
    }

    @RequestMapping("/rest/greeting/{id}")
    public Greeting greeting(@PathVariable long id) {
        return new Greeting(id,
                String.format(template, "world"));
    }

    @RequestMapping(value = "/rest/greeting", method=POST)
    public String greetingSubmit(@Validated Greeting greeting) {
        return "{ \"result\" : \"success\" }";
    }
}