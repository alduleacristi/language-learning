package learning.language.home.security;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import learning.language.home.languagelearning.R;
import learning.language.home.util.Configuration;

/**
 * Created by Cristi on 1/4/2017.
 */

public class LanguageLearningSSLContext {
    private final Context context;
    private final SSLContext sslContext;
    private final Configuration conf = Configuration.getInstance();

    public LanguageLearningSSLContext(Context context) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException, UnrecoverableKeyException {
        this.context = context;

        HttpsURLConnection.setDefaultHostnameVerifier(new NullHostNameVerifier());

        KeyStore trusted = KeyStore.getInstance("BKS");
        InputStream in = context.getResources().openRawResource(R.raw.client);
        trusted.load(in, conf.getTrustManagerPassword().toCharArray());
        TrustManagerFactory tmf = TrustManagerFactory
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trusted);

        KeyStore keyManager = KeyStore.getInstance("BKS");
        in = context.getResources().openRawResource(R.raw.client_keystore);
        keyManager.load(in, conf.getKeyStoreManagerPassword().toCharArray());
        KeyManagerFactory kmf = KeyManagerFactory
                .getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyManager, conf.getKeyStoreManagerPassword().toCharArray());
        sslContext = SSLContext.getInstance("SSL");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
    }

    public SSLContext getSslContext() {
        return sslContext;
    }
}
