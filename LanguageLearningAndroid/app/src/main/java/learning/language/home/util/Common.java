package learning.language.home.util;

import java.util.Map;

import language.learning.dto.ArticleDTO;

/**
 * Created by Cristi on 12/28/2016.
 */

public class Common {
    private static Common ourInstance = new Common();

    private boolean isInitialized;
    private Map<Long, ArticleDTO> articles;

    private Common() {
    }

    public static Common getInstance() {
        return ourInstance;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setInitialized(boolean initialized) {
        isInitialized = initialized;
    }

    public Map<Long, ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(Map<Long, ArticleDTO> articles) {
        this.articles = articles;
    }
}
