package learning.language.home.laguagelearning.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import language.learning.dto.ArticleDTO;
import learning.language.home.util.Common;

/**
 * Created by Cristi on 12/28/2016.
 */

public class InitializerService {
    private final Common common;
    private final ArticleService articleService;

    public InitializerService() {
        common = Common.getInstance();
        articleService = new ArticleService();
    }

    private void setArticles() {
        List<ArticleDTO> allArticles = articleService.getAllArticles();
        Map<Long, ArticleDTO> articles = new HashMap<>();

        for (ArticleDTO article : allArticles) {
            articles.put(article.getIdArticle(), article);
        }

        common.setArticles(articles);
    }

    public void initializeApp() {
        setArticles();
    }
}
