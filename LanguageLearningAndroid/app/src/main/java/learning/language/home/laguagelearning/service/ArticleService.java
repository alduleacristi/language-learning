package learning.language.home.laguagelearning.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import language.learning.dto.ArticleDTO;
import learning.language.home.util.Configuration;

/**
 * Created by Cristi on 12/8/2016.
 */

public class ArticleService {
    private final Client webClient;
    private final Configuration config = Configuration.getInstance();
    private final Gson gson;

    public ArticleService(){
        webClient = ClientBuilder.newClient();
        gson = new Gson();
    }

    public List<ArticleDTO> getAllArticles(){
        String articles = webClient.target(config.getHost()+":"+config.getPort()+"/language-learning/api/article").request().get(String.class);

        Type articlesType = new TypeToken<List<ArticleDTO>>() {
        }.getType();
        List<ArticleDTO> articleDTOs = gson.fromJson(articles, articlesType);

        return articleDTOs;
    }
}
