package pl.wanderers.footprint.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greetings {

    private long id;
    private String content;

    public Greetings() {
        // Jackson deserialization
    }

    public Greetings(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Greetings{" + "id=" + id + ", content='" + content + '\'' + '}';
    }
}
