package learning.language.home.laguagelearning.service;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import language.learning.dto.ArticleDTO;
import language.learning.dto.NounDTO;
import learning.language.home.exception.RemoteInvocationFailed;
import learning.language.home.security.LanguageLearningSSLContext;
import learning.language.home.util.Configuration;

/**
 * Created by Cristi on 12/8/2016.
 */

public class NounService {
    private final static String NR_OF_NOUNS_PARAM = "nrOfNouns";

    private final Client webClient;
    private final Configuration config = Configuration.getInstance();
    private final Gson gson;
    private final LanguageLearningSSLContext llSSLContext;

    public NounService(Context context) throws RemoteInvocationFailed {
        try {
            gson = new Gson();
            llSSLContext = new LanguageLearningSSLContext(context);
            webClient = ClientBuilder.newBuilder().sslContext(llSSLContext.getSslContext()).build();
        } catch (IOException e) {
            throw new RemoteInvocationFailed("SSL handshake failed");
        } catch (CertificateException e) {
            throw new RemoteInvocationFailed("SSL handshake failed");
        } catch (NoSuchAlgorithmException e) {
            throw new RemoteInvocationFailed("SSL handshake failed");
        } catch (KeyStoreException e) {
            throw new RemoteInvocationFailed("SSL handshake failed");
        } catch (KeyManagementException e) {
            throw new RemoteInvocationFailed("SSL handshake failed");
        } catch (UnrecoverableKeyException e) {
            throw new RemoteInvocationFailed("SSL handshake failed");
        }
    }

    public String getRandomNouns(Long nrOfNouns) {
        String nouns = webClient.target(config.getHost() + ":" + config.getPort() + config.getResource() + "randomNoun").queryParam(NR_OF_NOUNS_PARAM, nrOfNouns).request().get(String.class);

        return nouns;
    }
}
