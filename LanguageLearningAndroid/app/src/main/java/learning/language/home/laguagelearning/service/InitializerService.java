package learning.language.home.laguagelearning.service;

import android.content.Context;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import language.learning.dto.ArticleDTO;
import learning.language.home.exception.RemoteInvocationFailed;
import learning.language.home.util.Common;

/**
 * Created by Cristi on 12/28/2016.
 */

public class InitializerService {
    private final Common common;
    private final ArticleService articleService;

    public InitializerService(Context context) throws RemoteInvocationFailed {
        common = Common.getInstance();
        articleService = new ArticleService(context);
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
