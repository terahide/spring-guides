package hello;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GreetingService {
    private final static Map<Long,Greeting> greetings = new LinkedHashMap<>();

    public void save(Greeting greeting){
        greetings.put(greeting.getId(), greeting);
    }

    public List<Greeting> all(){
        return greetings.values().stream().collect(Collectors.toList());
    }

    public Greeting get(long id){
        if( ! greetings.containsKey(id)){
            throw new ResourceNotFoundException();
        }
        return greetings.get(id);
    }
}
