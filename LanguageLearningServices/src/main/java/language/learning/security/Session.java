package language.learning.security;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Singleton;

import language.learning.dto.Token;
import language.learning.model.User;

/**
 * Created by Cristi on 1/3/2017.
 */

@Singleton
@Startup
public class Session {
    private Map<String, Token> authenticatedUsers;

    @PostConstruct
    private void initialize() {
        authenticatedUsers = new HashMap<String, Token>();
    }

    public void addUser(String key, Token token) {
        authenticatedUsers.put(key, token);
        System.out.println(authenticatedUsers.size());
    }

    public Token getTokenByKey(String key) {
        return authenticatedUsers.get(key);
    }

    public void removeUser(String key){
        authenticatedUsers.remove(key);
        System.out.println(authenticatedUsers.size());
    }
}
