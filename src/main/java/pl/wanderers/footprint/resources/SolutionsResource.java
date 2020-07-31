package pl.wanderers.footprint.resources;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import pl.wanderers.footprint.core.Solution;
import pl.wanderers.footprint.db.SolutionDAO;

@Path("/solutions")
@Produces(MediaType.APPLICATION_JSON)
@Api
public class SolutionsResource {

    private static final Logger logger = LoggerFactory.getLogger(SolutionsResource.class);

    private final SolutionDAO solutionsDAO;

    public SolutionsResource(SolutionDAO solutionsDAO) {
        this.solutionsDAO = solutionsDAO;
    }

    @GET
    public List<Solution> listSolutions() {
        return solutionsDAO.findAll();
    }

    @GET
    @Path("/{solution-id}")
    public Solution get(@PathParam("solution-id") long solutionId) {
        String message = String.format("Solution with id=%d does not exist.", solutionId);
        return solutionsDAO.findById(solutionId)
                .orElseThrow(() -> new NotFoundException(message));
    }

    @POST
    public void addSolution(@Valid Solution solution) {
        solutionsDAO.create(solution);
    }
}
