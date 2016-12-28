package language.learning.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import language.learning.convertor.NounConverter;
import language.learning.dao.NounDAO;
import language.learning.dto.NounDTO;
import language.learning.exception.EntityNotFoundException;
import language.learning.exception.InvalidParamException;
import language.learning.model.Noun;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NounJaxRS {
    private static final Long DEFAULT_NR_OF_NOUNS = 5L;

    @Inject
    private NounDAO nounDAO;

    @GET
    @Path("/noun")
    public List<NounDTO> getAllNouns() {
        System.out.println("Trying to get all the nouns Web service");
        List<NounDTO> nounsDTO = new ArrayList<>();

        List<Noun> nouns = nounDAO.getAllNouns();
        for (Noun noun : nouns) {
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

    @GET
    @Path("/randomNoun")
    public List<NounDTO> getRandomListofNouns(@QueryParam("nrOfNouns") Long nrOfNouns) {
        List<NounDTO> nouns = new ArrayList<>();
        try {
            if (nrOfNouns == null) {
                nrOfNouns = DEFAULT_NR_OF_NOUNS;
            }

            if (nrOfNouns <= 0) {
                throw new InvalidParamException("The number of nouns must be positive");
            }

            Long totalNrOfNouns = nounDAO.getNumberOfNouns();

            for (int i = 0; i < nrOfNouns; i++) {
                Long randomNum = ThreadLocalRandom.current().nextLong(1, totalNrOfNouns);
                Noun currentNoun = nounDAO.getNounById(randomNum);
                NounDTO currentNounDTO = NounConverter.convertToDTO(currentNoun);
                nouns.add(currentNounDTO);
            }
            return nouns;
        } catch (InvalidParamException exc) {
            throw new BadRequestException(exc.getMessage());
        } catch (EntityNotFoundException e) {
            throw new ServerErrorException("Failed to get nouns", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
