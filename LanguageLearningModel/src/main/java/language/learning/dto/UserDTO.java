package language.learning.dto;

/**
 * Created by Cristi on 1/3/2017.
 */

public class UserDTO {
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmai(String emai) {
        this.email = emai;
    }
}
