package learning.language.home.laguagelearning.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import language.learning.dto.ArticleDTO;
import language.learning.dto.NounDTO;
import learning.language.home.util.Configuration;

/**
 * Created by Cristi on 12/8/2016.
 */

public class NounService {
    private final static String NR_OF_NOUNS_PARAM = "nrOfNouns";
    private final Client webClient;
    private final Configuration config = Configuration.getInstance();
    private final Gson gson;

    public NounService() {
        webClient = ClientBuilder.newClient();
        gson = new Gson();
    }

    public List<NounDTO> getRandomNouns(Long nrOfNouns) {
        String articles = webClient.target(config.getHost() + ":" + config.getPort() + config.getResource() + "randomNoun").queryParam(NR_OF_NOUNS_PARAM, nrOfNouns).request().get(String.class);

        Type nounType = new TypeToken<List<NounDTO>>() {
        }.getType();
        List<NounDTO> nounDTOs = gson.fromJson(articles, nounType);

        return nounDTOs;
    }
}
