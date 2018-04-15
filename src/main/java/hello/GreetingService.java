package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GreetingService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void save(Greeting greeting){
        jdbcTemplate.update("insert into greetings (id, content) values (?, ?)",greeting.getId(),greeting.getContent());
    }

    public List<Greeting> all(){
        return jdbcTemplate.query("select * from greetings",(rs, rowNum) -> toGreeting(rs));
    }

    private Greeting toGreeting(ResultSet rs) {
        try {
            return new Greeting(rs.getLong("ID"), rs.getString("CONTENT"));
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Greeting get(long id){
        try {
            return jdbcTemplate.queryForObject("select * from greetings where id = ?", (rs, rowNum) -> toGreeting(rs), id);
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException();
        }
    }
}
