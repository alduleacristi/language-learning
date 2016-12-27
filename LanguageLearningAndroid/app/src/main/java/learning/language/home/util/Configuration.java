package learning.language.home.util;

/**
 * Created by Cristi on 12/8/2016.
 */
public class Configuration {
    private static Configuration ourInstance = new Configuration();

    private String host = "http://192.168.0.103";
    private int port = 8080;

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
}
