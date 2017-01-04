package learning.language.home.laguagelearning.service;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.glassfish.jersey.client.ClientConfig;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import language.learning.dto.ArticleDTO;
import learning.language.home.exception.RemoteInvocationFailed;
import learning.language.home.languagelearning.R;
import learning.language.home.security.LanguageLearningSSLContext;
import learning.language.home.security.NullHostNameVerifier;
import learning.language.home.util.Configuration;

/**
 * Created by Cristi on 12/8/2016.
 */

public class ArticleService {
    private final Client webClient;
    private final Configuration config = Configuration.getInstance();
    private final Gson gson;
    private final LanguageLearningSSLContext llSSLContext;

    public ArticleService(Context context) throws RemoteInvocationFailed {
        try {
            gson = new Gson();
            llSSLContext = new LanguageLearningSSLContext(context);
            webClient = ClientBuilder.newBuilder().sslContext(llSSLContext.getSslContext()).build();
        } catch (IOException e) {
            Log.getStackTraceString(e);
            throw new RemoteInvocationFailed(e.getMessage());
        } catch (CertificateException e) {
            Log.getStackTraceString(e);
            throw new RemoteInvocationFailed(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            Log.getStackTraceString(e);
            throw new RemoteInvocationFailed(e.getMessage());
        } catch (KeyStoreException e) {
            Log.getStackTraceString(e);
            throw new RemoteInvocationFailed(e.getMessage());
        } catch (KeyManagementException e) {
            Log.getStackTraceString(e);
            throw new RemoteInvocationFailed(e.getMessage());
        } catch (UnrecoverableKeyException e) {
            Log.getStackTraceString(e);
            throw new RemoteInvocationFailed(e.getMessage());
        }
    }

    public List<ArticleDTO> getAllArticles() {
        String articles = webClient.target(config.getHost() + ":" + config.getPort() + "/language-learning/api/article").request().get(String.class);

        Type articlesType = new TypeToken<List<ArticleDTO>>() {
        }.getType();
        List<ArticleDTO> articleDTOs = gson.fromJson(articles, articlesType);

        return articleDTOs;
    }
}
