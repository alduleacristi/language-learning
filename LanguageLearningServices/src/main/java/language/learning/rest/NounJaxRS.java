package language.learning.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import language.learning.dao.LevelDAO;
import language.learning.model.Level;
import language.learning.model.Noun;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NounJaxRS {
	@Inject
	private LevelDAO levelDAO;

	@GET
	@Path("/noun")
	public List<Level> getTemperature() {
		// List<Level> tempertures = new ArrayList<>();
		// Noun temp1 = new Noun("aaa", levelDAO.getLevelById(1L));
		// Noun temp2 = new Noun("bbb", levelDAO.getLevelById(1L));
		// Noun temp3 = new Noun("ccc", levelDAO.getLevelById(1L));
		//
		// tempertures.add(temp1);
		// tempertures.add(temp2);
		// tempertures.add(temp3);

		return levelDAO.getAllLevels();
	}
}
