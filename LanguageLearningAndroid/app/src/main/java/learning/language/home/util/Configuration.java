package learning.language.home.util;

/**
 * Created by Cristi on 12/8/2016.
 */
public class Configuration {
    private static Configuration ourInstance = new Configuration();

    private String host = "https://192.168.0.104";
    private int port = 8443;
    private String resource = "/language-learning/api/";
    private String trustManagerPassword = "LLpass1q2w3e";
    private String keyStoreManagerPassword = "keypassword";

    public static Configuration getInstance() {
        return ourInstance;
    }

    private Configuration() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getTrustManagerPassword() {
        return trustManagerPassword;
    }

    public void setTrustManagerPassword(String trustManagerPassword) {
        this.trustManagerPassword = trustManagerPassword;
    }

    public String getKeyStoreManagerPassword() {
        return keyStoreManagerPassword;
    }

    public void setKeyStoreManagerPassword(String keyStoreManagerPassword) {
        this.keyStoreManagerPassword = keyStoreManagerPassword;
    }
}
