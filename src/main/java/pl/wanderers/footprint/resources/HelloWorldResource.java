package pl.wanderers.footprint.resources;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.caching.CacheControl;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import pl.wanderers.footprint.api.Greetings;
import pl.wanderers.footprint.core.Template;

@Path("/hello-world")
@Api
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldResource.class);

    private final Template template;
    private final AtomicLong counter;

    public HelloWorldResource(Template template) {
        this.template = template;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed(name = "get-requests-timed")
    @Metered(name = "get-requests-metered")
    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    public Greetings sayHello(@QueryParam("name") @Nullable String name) {
        logger.info("Requested to say hello: {}", name);
        return new Greetings(counter.incrementAndGet(), template.render(Optional.ofNullable(name)));
    }

    @POST
    public void receiveHello(Greetings saying) {
        logger.info("Received a saying: {}", saying);
    }
}