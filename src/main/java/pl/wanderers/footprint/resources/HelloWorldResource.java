package pl.wanderers.footprint.resources;

import com.codahale.metrics.annotation.Timed;

import javax.annotation.Nullable;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import pl.wanderers.footprint.api.Greetings;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Greetings sayHello(@QueryParam("name") @Nullable String name) {
        final String value = String.format(template, Optional.ofNullable(name).orElse(defaultName));
        return new Greetings(counter.incrementAndGet(), value);
    }
}