package language.learning.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import language.learning.convertor.LevelConvertor;
import language.learning.dao.LevelDAO;
import language.learning.dto.LevelDTO;
import language.learning.exception.EntityNotFoundException;
import language.learning.model.Level;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LevelJaxRS {
	@Inject
	private LevelDAO levelDAO;

	@GET
	@Path("/level")
	public List<LevelDTO> getAllLevels() {
		List<LevelDTO> levelsDTO = new ArrayList<>();
		levelDAO.getAllLevels().forEach((l) -> {
			levelsDTO.add(LevelConvertor.convertToDTO(l));
		});

		return levelsDTO;
	}

	@GET
	@Path("/levelById")
	public LevelDTO getLevelById(@QueryParam("id") Long idLevel) {
		try {
			System.out.println("Trying to get level with id: [" + idLevel + "]");
			Level level = levelDAO.getLevelById(idLevel);
			return LevelConvertor.convertToDTO(level);
		} catch (EntityNotFoundException enf) {
			throw new NotFoundException(enf.getMessage());
		}
	}
}
