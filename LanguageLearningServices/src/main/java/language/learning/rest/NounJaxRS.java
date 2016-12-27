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

import language.learning.convertor.NounConverter;
import language.learning.dao.NounDAO;
import language.learning.dto.NounDTO;
import language.learning.exception.EntityNotFoundException;
import language.learning.model.Noun;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NounJaxRS {
	@Inject
	private NounDAO nounDAO;

	@GET
	@Path("/noun")
	public List<NounDTO> getAllNouns() {
		System.out.println("Trying to get all the nouns Web service");
		List<NounDTO> nounsDTO = new ArrayList<>();

		List<Noun> nouns = nounDAO.getAllNouns();
		for(Noun noun:nouns){
			nounsDTO.add(NounConverter.convertToDTO(noun));
		}

		return nounsDTO;
	}

	@GET
	@Path("/nounById")
	public NounDTO getNounById(@QueryParam("id") Long idNoun) {
		try {
			System.out.println("Trying to get noun with id [" + idNoun + "]");
			Noun noun = nounDAO.getNounById(idNoun);
			return NounConverter.convertToDTO(noun);
		} catch (EntityNotFoundException enf) {
			throw new NotFoundException(enf.getMessage());
		}
	}
}
