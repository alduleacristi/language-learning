package language.learning.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import language.learning.dao.LevelDAO;
import language.learning.model.Level;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LevelJaxRS {
	@Inject
	private LevelDAO levelDAO;

	@GET
	@Path("/level")
	public List<Level> getAllLevels() {
		return levelDAO.getAllLevels();
	}

	@GET
	@Path("/level/{id}")
	public Level getLevelById(@PathParam("id") Long idLevel) {
		return levelDAO.getLevelById(idLevel);
	}
}
