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
import pl.wanderers.footprint.core.Template;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final Template template;
    private final AtomicLong counter;

    public HelloWorldResource(Template template) {
        this.template = template;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Greetings sayHello(@QueryParam("name") @Nullable String name) {
        return new Greetings(counter.incrementAndGet(), template.render(Optional.ofNullable(name)));
    }
}