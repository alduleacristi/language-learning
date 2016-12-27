package learning.language.home.laguagelearning.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import java.util.List;

import javax.ws.rs.core.MediaType;

import language.learning.dto.ArticleDTO;
import learning.language.home.util.Configuration;

/**
 * Created by Cristi on 12/8/2016.
 */

public class ArticleService {
    private final Client webClient;
    WebResource webResource;
    Configuration config = Configuration.getInstance();

    public ArticleService(){
        webClient = Client.create();
        webResource = webClient.resource(config.getHost()+":"+config.getPort()+"/language-learning/api/article");
    }

    public List<ArticleDTO> getAllArticles(){
        return webResource.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<ArticleDTO>>(){});
    }
}
