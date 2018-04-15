package hello;

import javax.validation.constraints.*;

public class Greeting {

    @NotNull
    @Min(0)
    private long id;

    @NotNull
    @Size(min=2, max=30)
    private String content;

    public Greeting(){
        super();
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}